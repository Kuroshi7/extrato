package com.ibolt.extrato.config;

import inter.sdk.InterSdk;
import inter.sdk.commons.exceptions.SdkException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterSdkConfig {

    @Bean
    public InterSdk interSdk() {
        try {
            InterSdk sdk = new InterSdk(
                    "SANDBOX",
                    "319cf653-1199-4989-b8ee-0f23d277476a",
                    "7df76e42-1f55-4e1a-a887-012326b21224",
                    "src/main/resources/certificados/certificadosandbox.pfx",
                    "1234"
            );
            sdk.setDebug(true);
            sdk.setRateLimitControl(false);
            return sdk;
        } catch (SdkException e) {
            throw new RuntimeException("Erro ao configurar o InterSdk", e);
        }
    }
}
