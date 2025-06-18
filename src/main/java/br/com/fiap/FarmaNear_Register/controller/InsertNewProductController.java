package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.usecases.InsertNewProductUseCase;

public class InsertNewProductController {

    private final InsertNewProductUseCase insertNewProductUseCase;

    public InsertNewProductController(InsertNewProductUseCase insertNewProductUseCase) {
        this.insertNewProductUseCase = insertNewProductUseCase;
    }

    public ProductDto insertNewProduct(ProductDto productDto) {
        return this.insertNewProductUseCase.insertNewProduct(productDto);
    }
}
