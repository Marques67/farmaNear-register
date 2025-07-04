package br.com.fiap.FarmaNear_Register.infra.config;

import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import br.com.fiap.FarmaNear_Register.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    UploadCsvUseCase uploadCsvUseCase(IProductJpaGateway productJpaGateway) {
        return new UploadCsvUseCase(productJpaGateway);
    }

    @Bean
    InsertNewProductUseCase insertNewProductUseCase(IProductJpaGateway productJpaGateway) {
        return new InsertNewProductUseCase(productJpaGateway);
    }

    @Bean
    CreateDrugstoreUseCase createDrugstoreUseCase(IDrugstoreJpaGateway drugstoreJpaGateway) {
        return new CreateDrugstoreUseCase(drugstoreJpaGateway);
    }

    @Bean
    GetDrugstoreByProductsUseCase getDrugstoreByProductController(IProductJpaGateway productJpaGateway) {
        return new GetDrugstoreByProductsUseCase(productJpaGateway);
    }

    @Bean
    GetDrugstoreUseCase getDrugstoreUseCase(IDrugstoreJpaGateway drugstoreJpaGateway) {
        return new GetDrugstoreUseCase(drugstoreJpaGateway);
    }

    @Bean
    GetProductsUseCase getProductsUseCase(IProductJpaGateway productJpaGateway) {
        return new GetProductsUseCase(productJpaGateway);
    }

    @Bean
    TokenUseCase tokenUseCase() {
        return new TokenUseCase();
    }
}
