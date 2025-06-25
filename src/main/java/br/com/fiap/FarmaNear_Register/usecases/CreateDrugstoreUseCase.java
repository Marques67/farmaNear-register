package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;

public class CreateDrugstoreUseCase {

    private final IDrugstoreJpaGateway drugstoreJpaGateway;

    public CreateDrugstoreUseCase(IDrugstoreJpaGateway drugstoreJpaGateway) {
        this.drugstoreJpaGateway = drugstoreJpaGateway;
    }

    public DrugstoreDto createDrugstore(InsertDrugstoreDto insertDrugstoreDto) {
        return drugstoreJpaGateway.createDrugstore(insertDrugstoreDto);
    }
}
