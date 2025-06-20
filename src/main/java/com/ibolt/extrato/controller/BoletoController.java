package com.ibolt.extrato.controller;


import inter.sdk.InterSdk;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoletoController {

    private final InterSdk sdk;

    public BoletoController(InterSdk sdk) {
        this.sdk = sdk;
    }

    @PostMapping("/boleto")
    public String createBoleto(){

    }

}
