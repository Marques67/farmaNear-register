package br.com.fiap.FarmaNear_Register.application.dto;

public record DrugstoreDto(Long id, Integer cnpj, String name, String email, String password, String phone, AddresDto address) {

    public DrugstoreDto(long id, Integer cpf, String name, String email, String password, String phone) {
        this(id, cpf, name, email, password, phone, null);
    }
}
