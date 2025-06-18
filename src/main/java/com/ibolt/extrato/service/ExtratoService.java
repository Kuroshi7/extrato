package com.ibolt.extrato.service;

import inter.sdk.banking.models.EnrichedBankStatementPage;
import inter.sdk.banking.models.EnrichedTransaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExtratoService {

    public BigDecimal calcularTotalEntrada(EnrichedBankStatementPage page) {
        return page.getTransactions().stream()
                .filter(t -> "C".equalsIgnoreCase(t.getOperationType()))
                .map(t -> parseBigDecimal(t.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularTotalEntrada(List<EnrichedTransaction> transactions) {
        return transactions.stream()
                .filter(t -> "C".equalsIgnoreCase(t.getOperationType()))
                .map(t -> parseBigDecimal(t.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularTotalSaida(EnrichedBankStatementPage page) {
        return page.getTransactions().stream()
                .filter(t -> "D".equalsIgnoreCase(t.getOperationType()))
                .map(t -> parseBigDecimal(t.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularTotalSaida(List<EnrichedTransaction> transactions) {
        return transactions.stream()
                .filter(t -> "D".equalsIgnoreCase(t.getOperationType()))
                .map(t -> parseBigDecimal(t.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal parseBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }
}