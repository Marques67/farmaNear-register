package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import br.com.fiap.FarmaNear_Register.usecases.GetDrugstoreUseCase;

public class GetDrugstoreController {

    private final GetDrugstoreUseCase getDrugstoreUseCase;

    public GetDrugstoreController(GetDrugstoreUseCase getDrugstoreUseCase) {
        this.getDrugstoreUseCase = getDrugstoreUseCase;
    }

    public GetDrugstoreDataDto getDrugstore(Long cnpj) {
        return getDrugstoreUseCase.getDrugstore(cnpj);
    }
}
