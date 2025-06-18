package com.ibolt.extrato.controller;


import com.ibolt.extrato.dto.ExtratoResponse;
import com.ibolt.extrato.model.TransacaoEntity;
import com.ibolt.extrato.repository.TransacaoRepository;
import com.ibolt.extrato.service.ExtratoService;
import inter.sdk.InterSdk;
import inter.sdk.banking.balance.BalanceClient;
import inter.sdk.banking.models.Balance;
import inter.sdk.banking.models.EnrichedBankStatementPage;

import inter.sdk.banking.models.EnrichedTransaction;
import inter.sdk.commons.models.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import inter.sdk.banking.bankstatement.BankStatementClient;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController// define como uma API rest injeção de dependencias
@Validated// biblioteca para validar respostas/campos
public class ExtratoController {

    @Autowired //injeção de dependencia automatica Autowired para o programa ter referencia isso vem do serviço
    private ExtratoService extratoService;

    @Autowired// mesmo cois mas isso chama o repositorio
    private TransacaoRepository transacaoRepository;

    @GetMapping("/extrato")// getmapping define rotas
    public ExtratoResponse getExtrato(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(50) int size//definiçao de maximo e minimo de chamadas para pagina e tamaho da resposta
    ) throws Exception {

        // SDK call (existing) chamada do sdk
        InterSdk sdk = new InterSdk(
                "SANDBOX",
                "319cf653-1199-4989-b8ee-0f23d277476a",
                "7df76e42-1f55-4e1a-a887-012326b21224",
                "src/main/resources/certificados/certificadosandbox.pfx",
                "1234"
        );
        sdk.setDebug(true);
        sdk.setRateLimitControl(false);

        String dataInicio = java.time.LocalDate.of(2023, 1, 1).toString();
        String dataFim = java.time.LocalDate.of(2023, 1, 2).toString();

        BankStatementClient client = new BankStatementClient();// isso chama a classe do sdk
        List<EnrichedTransaction> todasTransacoes = sdk.banking().retrieveEnrichedStatement(dataInicio, dataFim, null);


        EnrichedBankStatementPage sdkResponse = client.retrieveStatementPage(
                sdk.getConfig(), dataInicio, dataFim, page, size, null
        ); //aqui ta configurando como quer a resposta sdkResponse vai receber isso para virar um json

        // Database call chama a base de dados como lista, o findAll é o ORM do JPA
        List<TransacaoEntity> dbResponse = transacaoRepository.findAll();

        //Balance call chamada do saldo completa
        BalanceClient balanceClient = new BalanceClient();
        Balance sdkBalance = balanceClient.retrieve_balance(sdk.getConfig(), null);// metodos e parametros


        //Total IN and OUT
        BigDecimal totalEntrada = extratoService.calcularTotalEntrada(todasTransacoes);
        BigDecimal totalSaida = extratoService.calcularTotalSaida(todasTransacoes);


        // Combine responses aqui combina as resposta e coloca tudo em uma rota só
        ExtratoResponse response = new ExtratoResponse();
        response.setSdkResponse(sdkResponse);
        response.setDbResponse(dbResponse);
        response.setSdkBalance(sdkBalance);
        response.setTotalEntrada(totalEntrada);
        response.setTotalSaida(totalSaida);

        return response;
    }
}


