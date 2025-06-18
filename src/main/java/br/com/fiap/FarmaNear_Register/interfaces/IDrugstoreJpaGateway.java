package br.com.fiap.FarmaNear_Register.interfaces;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;

public interface IDrugstoreJpaGateway {

    DrugstoreDto createDrugstore(DrugstoreDto drugstore);
}
