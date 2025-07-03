package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;

public class GetDrugstoreUseCase {

    private final IDrugstoreJpaGateway drugstoreJpaGateway;

    public GetDrugstoreUseCase(IDrugstoreJpaGateway drugstoreJpaGateway) {
        this.drugstoreJpaGateway = drugstoreJpaGateway;
    }

    public GetDrugstoreDataDto getDrugstore(Long cnpj){
        return drugstoreJpaGateway.getDrugstoreByCnpj(cnpj);
    }
}
