package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
import br.com.fiap.FarmaNear_Register.usecases.GetProductsByCnpjUseCase;

import java.util.List;

public class GetProductsByCnpjController {

    private final GetProductsByCnpjUseCase getProductsByCnpjUseCase;

    public GetProductsByCnpjController(GetProductsByCnpjUseCase getProductsByCnpjUseCase) {
        this.getProductsByCnpjUseCase = getProductsByCnpjUseCase;
    }

    public List<GetProductDataDto> getProducts(String cnpj) {
        return getProductsByCnpjUseCase.getProductsByCnpj(cnpj);
    }
}
