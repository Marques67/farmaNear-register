package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreByProductDto;
import br.com.fiap.FarmaNear_Register.usecases.GetDrugstoreByProductsUseCase;

public class GetDrugstoreByProductController {

    private final GetDrugstoreByProductsUseCase getProductsUseCase;

    public GetDrugstoreByProductController(GetDrugstoreByProductsUseCase getProductsUseCase) {
        this.getProductsUseCase = getProductsUseCase;
    }

    public GetDrugstoreByProductDto getDrugstoreByProduct(String productName) {
        return getProductsUseCase.getProduct(productName);
    }


}
