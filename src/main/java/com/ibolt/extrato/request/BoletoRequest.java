package com.ibolt.extrato.request;

import lombok.Data;

@Data
public class BoletoRequest {
    private Long id;

    private Long codigoPagamento;

    private String vencimento;

    private Double valor;
    private String codigoOrigem;
    private String nome;
    private String cpfCnpj;
    private String cep;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String email;
    private String observacao;
    private String auxUm;
    private String auxDois;
    private String auxTres;
    private String auxQuatro;
    private String auxCinco;
    private String nomeRetorno;
    private String identificador;
    private String datapagamento;
    private String dataRetorno;
    private Long operadora;
    private Long formaPagamentoConta;
    private Object composicao;
    private double jurosBanco;
    private double tarifa;
    private String json;
    private String numBoleto;
    private String url;
    private String idOperadora;
    private String formaPagamento;
    private String dataVencimento;
    private String dataGeracao;
    private double valorPago;
    private String empresa;
    private String dataCancelamento;
    private String linhaDigitavel;
    private String codigoBarras;
}
