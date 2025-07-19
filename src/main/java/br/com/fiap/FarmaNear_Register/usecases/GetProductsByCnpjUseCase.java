package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;

import java.util.List;

public class GetProductsByCnpjUseCase {

    private final IProductJpaGateway productJpaGateway;

    public GetProductsByCnpjUseCase(IProductJpaGateway productJpaGateway) {
        this.productJpaGateway = productJpaGateway;
    }

    public List<GetProductDataDto> getProductsByCnpj(String cnpj) {
        return productJpaGateway.getProductsByCnpj(cnpj);
    }
}
