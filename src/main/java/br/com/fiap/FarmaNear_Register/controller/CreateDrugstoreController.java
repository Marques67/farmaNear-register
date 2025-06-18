package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.usecases.CreateDrugstoreUseCase;

public class CreateDrugstoreController {

    private final CreateDrugstoreUseCase createDrugstoreUseCase;

    public CreateDrugstoreController(CreateDrugstoreUseCase createDrugstoreUseCase) {
        this.createDrugstoreUseCase = createDrugstoreUseCase;
    }

    public DrugstoreDto createDrugstore(DrugstoreDto drugstoreDto) {
        return this.createDrugstoreUseCase.createDrugstore(drugstoreDto);
    }
}
