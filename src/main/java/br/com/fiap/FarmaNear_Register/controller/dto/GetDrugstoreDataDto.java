package br.com.fiap.FarmaNear_Register.controller.dto;

import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;

public record GetDrugstoreDataDto(Long cnpj, String name, String email, String phone, AddressDto address) {

    public GetDrugstoreDataDto(DrugstoreEntity drugstoreEntity) {
        this(drugstoreEntity.getCnpj(),
                drugstoreEntity.getName(),
                drugstoreEntity.getEmail(),
                drugstoreEntity.getPhone(),
                new AddressDto(drugstoreEntity.getAddress())) ;
    }
}
