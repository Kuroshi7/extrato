package com.ibolt.extrato.service;

import com.ibolt.extrato.request.BoletoRequest;
import inter.sdk.InterSdk;
import inter.sdk.billing.enums.PersonType;
import inter.sdk.billing.models.BillingIssueRequest;
import inter.sdk.billing.models.BillingIssueResponse;
import inter.sdk.billing.models.Message;
import inter.sdk.billing.models.Person;
import inter.sdk.commons.exceptions.SdkException;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

@Service
public class BoletoService {

    public BoletoRequest createBoletoInter(BoletoRequest boletoRequest, InterSdk interSdk) {
        try {
            interSdk.setDebug(true);

            // Criação do pagador
            Person pagador = Person.builder()
                    .name(boletoRequest.getNome())
                    .cpfCnpj(boletoRequest.getCpfCnpj())
                    .personType(PersonType.FISICA) // ou JURIDICA se for empresa
                    .email(boletoRequest.getEmail())
                    .address(boletoRequest.getLogradouro())
                    .number(String.valueOf(boletoRequest.getNumero()))
                    .neighborhood(boletoRequest.getBairro())
                    .city(boletoRequest.getCidade())
                    .state(boletoRequest.getUf())
                    .zipCode(boletoRequest.getCep())
                    .build();

            // Criação da mensagem (instruções do boleto)
            Message mensagem = Message.builder()
                    .line1("Pagável em qualquer banco até o vencimento.")
                    .line2("Após vencimento, cobrar multa e juros.")
                    .build();

            // Criação do boleto
            BillingIssueRequest boleto = BillingIssueRequest.builder()
                    .yourNumber(boletoRequest.getIdentificador()) // campo obrigatório
                    .nominalValue(BigDecimal.valueOf(boletoRequest.getValor()))
                    .dueDate(boletoRequest.getDataVencimento()) // YYYY-MM-DD
                    .scheduledDays(0) // dias para cancelamento automático
                    .payer(pagador)
                    .message(mensagem)
                    .build();

            // Envio para o Inter
            BillingIssueResponse resposta = interSdk.billing().issueBilling(boleto);

            // Preenche retorno no seu DTO, se quiser
//            boletoRequest.setNumBoleto(resposta.getOurNumber());
//            boletoRequest.setLinhaDigitavel(resposta.getDigitableLine());
//            boletoRequest.setCodigoBarras(resposta.getBarCode());
//            boletoRequest.setUrl(resposta.getPdfUrl()); VERIFICAR METODOS ***********

            return boletoRequest;

        } catch (SdkException e) {
            throw new RuntimeException("Erro ao emitir boleto com o Banco Inter", e);
        }
    }
}
