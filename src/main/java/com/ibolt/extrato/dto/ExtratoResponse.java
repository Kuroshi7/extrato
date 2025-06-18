package com.ibolt.extrato.dto;

import com.ibolt.extrato.model.TransacaoEntity;
import inter.sdk.banking.models.Balance;
import inter.sdk.banking.models.EnrichedBankStatementPage;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data // injeção de dependencia DTO pra padronizar resposta JSON
public class ExtratoResponse {
    private EnrichedBankStatementPage sdkResponse;
    private List<TransacaoEntity> dbResponse;
    private Balance sdkBalance;
    private BigDecimal totalEntrada;
    private BigDecimal totalSaida;

}
