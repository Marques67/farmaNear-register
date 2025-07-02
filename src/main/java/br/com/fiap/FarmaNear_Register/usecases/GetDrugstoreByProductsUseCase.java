package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreByProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;

public class GetDrugstoreByProductsUseCase {

    private final IProductJpaGateway productJpaGateway;

    public GetDrugstoreByProductsUseCase(IProductJpaGateway productJpaGateway) {
        this.productJpaGateway = productJpaGateway;
    }

    public GetDrugstoreByProductDto getProduct(String productName) {
        validatesName(productName);
        var drugstores = productJpaGateway.getDrugstoreByProduct(productName);
        return new GetDrugstoreByProductDto(productName, drugstores);
    }

    private void validatesName(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }
    }
}
