package br.com.fiap.FarmaNear_Register.infra.config;

import br.com.fiap.FarmaNear_Register.controller.CreateDrugstoreController;
import br.com.fiap.FarmaNear_Register.controller.InsertNewProductController;
import br.com.fiap.FarmaNear_Register.controller.UploadCsvController;
import br.com.fiap.FarmaNear_Register.usecases.CreateDrugstoreUseCase;
import br.com.fiap.FarmaNear_Register.usecases.InsertNewProductUseCase;
import br.com.fiap.FarmaNear_Register.usecases.UploadCsvUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {


    @Bean
    UploadCsvController uploadCsvController(UploadCsvUseCase uploadCsvUseCase) {
        return new UploadCsvController(uploadCsvUseCase);
    }

    @Bean
    InsertNewProductController insertNewProductController(InsertNewProductUseCase insertNewProductUseCase) {
        return new InsertNewProductController(insertNewProductUseCase);
    }

    @Bean
    CreateDrugstoreController createDrugstoreController(CreateDrugstoreUseCase createDrugstoreUseCase) {
        return new CreateDrugstoreController(createDrugstoreUseCase);
    }
}
