package br.com.fiap.FarmaNear_Register.infra.config;

import br.com.fiap.FarmaNear_Register.controller.UploadCsvController;
import br.com.fiap.FarmaNear_Register.usecases.UploadCsvUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterConfig {

    @Bean
    UploadCsvController uploadCsvController(UploadCsvUseCase uploadCsvUseCase){
        return new UploadCsvController(uploadCsvUseCase);
    }

    @Bean
    UploadCsvUseCase uploadCsvUseCase() {
        return new UploadCsvUseCase();
    }
}
