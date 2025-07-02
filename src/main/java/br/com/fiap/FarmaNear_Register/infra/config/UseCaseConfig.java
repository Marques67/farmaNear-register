package br.com.fiap.FarmaNear_Register.infra.config;

import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import br.com.fiap.FarmaNear_Register.usecases.CreateDrugstoreUseCase;
import br.com.fiap.FarmaNear_Register.usecases.GetDrugstoreByProductsUseCase;
import br.com.fiap.FarmaNear_Register.usecases.InsertNewProductUseCase;
import br.com.fiap.FarmaNear_Register.usecases.UploadCsvUseCase;
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
    GetDrugstoreByProductsUseCase getProductsUseCase(IProductJpaGateway productJpaGateway) {
        return new GetDrugstoreByProductsUseCase(productJpaGateway);
    }
}
