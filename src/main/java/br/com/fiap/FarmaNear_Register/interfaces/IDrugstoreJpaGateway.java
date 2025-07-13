package br.com.fiap.FarmaNear_Register.interfaces;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;

import java.util.Optional;

public interface IDrugstoreJpaGateway {

    DrugstoreDto createDrugstore(InsertDrugstoreDto insertDrugstoreDto);

    Optional<DrugstoreEntity> getDrugstoreByCnpj(String cnpj);
}
