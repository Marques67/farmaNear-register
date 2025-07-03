package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
import br.com.fiap.FarmaNear_Register.usecases.GetProductsUseCase;

import java.util.List;

public class GetProductsController {

    private final GetProductsUseCase getProductsUseCase;

    public GetProductsController(GetProductsUseCase getProductsUseCase) {
        this.getProductsUseCase = getProductsUseCase;
    }

    public List<GetProductDataDto> getProducts(String productName) {
        return getProductsUseCase.getProducts(productName);
    }
}
