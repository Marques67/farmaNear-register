package br.com.fiap.FarmaNear_Register.interfaces;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;

public interface IDrugstoreJpaGateway {

    DrugstoreDto createDrugstore(InsertDrugstoreDto insertDrugstoreDto);

    GetDrugstoreDataDto getDrugstoreByCnpj(Long cnpj);
}
