package br.com.fiap.FarmaNear_Register.infra.config;

import br.com.fiap.FarmaNear_Register.controller.*;
import br.com.fiap.FarmaNear_Register.usecases.*;
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

    @Bean
    GetDrugstoreByProductController getProductController(GetDrugstoreByProductsUseCase getProductsUseCase) {
        return new GetDrugstoreByProductController(getProductsUseCase);
    }

    @Bean
    GetDrugstoreController getDrugstoreController(GetDrugstoreUseCase getDrugstoreUseCase) {
        return new GetDrugstoreController(getDrugstoreUseCase);
    }

    @Bean
    GetProductsController getProductsController(GetProductsUseCase getProductsUseCase) {
        return new GetProductsController(getProductsUseCase);
    }

    @Bean
    GetProductsByCnpjController getProductsByCnpjController(GetProductsByCnpjUseCase getProductsByCnpjUseCase) {
        return new GetProductsByCnpjController(getProductsByCnpjUseCase);
    }
}
