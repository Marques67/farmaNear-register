package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;

import java.util.List;

public class GetProductsUseCase {

    private final IProductJpaGateway productJpaGateway;

    public GetProductsUseCase(IProductJpaGateway productJpaGateway) {
        this.productJpaGateway = productJpaGateway;
    }

    public List<GetProductDataDto> getProducts(String name){
       return productJpaGateway.getProducts(name);
    }
}
