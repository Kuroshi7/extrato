//package com.ibolt.extrato.controller;
//
//import com.ibolt.extrato.model.TransacaoEntity;
//import com.ibolt.extrato.repository.TransacaoRepository;
//import com.ibolt.extrato.service.FileMakerTransferService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/transferir")
//@Slf4j
//
//public class TransferenciaController {
//
//    @Autowired
//    private FileMakerTransferService fileMakerTransferService;
//
//    @PostMapping
//    public ResponseEntity<String> transferirTransacoes() {
//        try {
//            log.info("Iniciando processo de transferência para FileMaker");
//            int total = fileMakerTransferService.transferirParaFilemaker();
//            log.info("Transferência concluída com sucesso. Total: {}", total);
//            return ResponseEntity.ok("Total de transações transferidas: " + total);
//        } catch (Exception e) {
//            log.error("Erro durante a transferência para FileMaker", e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Erro durante a transferência: " + e.getMessage());
//        }
//    }
//
//}