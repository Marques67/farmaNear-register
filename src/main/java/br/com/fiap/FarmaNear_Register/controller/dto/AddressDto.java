package br.com.fiap.FarmaNear_Register.controller.dto;

import br.com.fiap.FarmaNear_Register.infra.repository.address.AddressEntity;

public record AddressDto(String street, String number, String complement, String city, String state, String zipCode) {

    public AddressDto(AddressEntity addressEntity) {
        this(addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getComplement(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getZipCode());
    }
}
