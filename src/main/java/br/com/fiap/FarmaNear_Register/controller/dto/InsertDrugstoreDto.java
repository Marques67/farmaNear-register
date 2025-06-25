package br.com.fiap.FarmaNear_Register.controller.dto;

public record InsertDrugstoreDto(Long cnpj, String name, String email, String phone, AddressDto address) {

    public InsertDrugstoreDto(Long cnpj, String name, String email, String phone) {
        this(cnpj, name, email, phone, null);
    }
}
