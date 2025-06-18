package com.ibolt.extrato.repository;


import com.ibolt.extrato.model.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity, String> {

    List<TransacaoEntity> findByValidacao(String validacao);
}
