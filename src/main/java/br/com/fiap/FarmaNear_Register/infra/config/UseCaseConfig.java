package br.com.fiap.FarmaNear_Register.infra.config;

import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import br.com.fiap.FarmaNear_Register.interfaces.IQueueGateway;
import br.com.fiap.FarmaNear_Register.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    UploadCsvUseCase uploadCsvUseCase(IProductJpaGateway productJpaGateway, GetDrugstoreUseCase getDrugstoreUseCase) {
        return new UploadCsvUseCase(productJpaGateway, getDrugstoreUseCase);
    }

    @Bean
    InsertNewProductUseCase insertNewProductUseCase(IProductJpaGateway productJpaGateway, GetDrugstoreUseCase getDrugstoreUseCase) {
        return new InsertNewProductUseCase(productJpaGateway, getDrugstoreUseCase);
    }

    @Bean
    CreateDrugstoreUseCase createDrugstoreUseCase(IDrugstoreJpaGateway drugstoreJpaGateway, IQueueGateway queueGateway) {
        return new CreateDrugstoreUseCase(drugstoreJpaGateway, queueGateway);
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

    @Bean
    GetProductsByCnpjUseCase getProductsByCnpjUseCase(IProductJpaGateway productJpaGateway) {
        return new GetProductsByCnpjUseCase(productJpaGateway);
    }
}
