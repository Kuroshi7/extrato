//package com.ibolt.extrato.service;
//
//
//import com.ibolt.extrato.model.TransacaoEntity;
//import com.ibolt.extrato.repository.TransacaoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.*;
//import java.util.List;
//
//@Service
//public class FileMakerTransferService {
//
//
//    @Autowired
//    TransacaoRepository transacaoRepository;
//
//    public  int transferirParaFilemaker(){
//        List <TransacaoEntity> transacoes = transacaoRepository.findAll();
//
//        String jdbcUrl = "jdbc:filemaker://localhost/transacao?user=extratoadm&password=123";
//
//        int inseridos = 0;
//
//        try(Connection conn = DriverManager.getConnection(jdbcUrl)) {
//            String sql = "INSERT INTO transacoes(id, descricao, data, valor, tipo, validacao) VALUES (?, ?, ?, ?, ?, ?)";
//            try(PreparedStatement stmt = conn.prepareStatement(sql)){
//                for(TransacaoEntity t : transacoes){
//                    stmt.setString(1, t.getId());
//                    stmt.setString(2, t.getDescricao());
//                    stmt.setDate(3, Date.valueOf(t.getData()));
//                    stmt.setBigDecimal(4, t.getValor());
//                    stmt.setString(5, t.getTipo());
//                    stmt.setString(6, t.getValidacao());
//                    stmt.addBatch();
//                }
//                int[] res = stmt.executeBatch();
//                inseridos = res.length;
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//    return inseridos;
//    }
//}
