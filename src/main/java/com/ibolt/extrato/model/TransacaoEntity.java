package com.ibolt.extrato.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transacoes")// validação da entidade do banco de dados
public class TransacaoEntity {
    @Id
    private String id;
    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    private String tipo;
    private String validacao = "pendente";

}
