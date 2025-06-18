package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;

public class InsertNewProductUseCase {

    private final IProductJpaGateway productJpaGateway;

    public InsertNewProductUseCase(IProductJpaGateway productJpaGateway) {
        this.productJpaGateway = productJpaGateway;
    }

    public ProductDto insertNewProduct(ProductDto productDto) {
        return productJpaGateway.saveProduct(productDto);
    }
}
