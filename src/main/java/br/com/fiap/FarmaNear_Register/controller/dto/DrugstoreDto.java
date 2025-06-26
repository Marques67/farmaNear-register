package br.com.fiap.FarmaNear_Register.controller.dto;

public record DrugstoreDto(String id, Long cnpj, String name, String email, String phone, AddressDto address) {

    public DrugstoreDto(String id, Long cnpj, String name, String email, String phone) {
        this(id, cnpj, name, email, phone, null);
    }
}
