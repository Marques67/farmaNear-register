package br.com.fiap.FarmaNear_Register.controller.dto;

public record DrugstoreDto(String cnpj, String name, String email, String phone, AddressDto address) {

    public DrugstoreDto(String cnpj, String name, String email, String phone) {
        this(cnpj, name, email, phone, null);
    }
}
