package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;
import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;

import java.util.Optional;

public class GetDrugstoreUseCase {

    private final IDrugstoreJpaGateway drugstoreJpaGateway;

    public GetDrugstoreUseCase(IDrugstoreJpaGateway drugstoreJpaGateway) {
        this.drugstoreJpaGateway = drugstoreJpaGateway;
    }

    public GetDrugstoreDataDto getDrugstore(Long cnpj) {
        Optional<DrugstoreEntity> drugstoreEntityOptional = drugstoreJpaGateway.getDrugstoreByCnpj(cnpj);

        if (drugstoreEntityOptional.isPresent()) {
            DrugstoreEntity drugstore = drugstoreEntityOptional.get();
            return new GetDrugstoreDataDto(drugstore);
        } else {
            throw new RuntimeException("Drugstore not found");
        }
    }
}
