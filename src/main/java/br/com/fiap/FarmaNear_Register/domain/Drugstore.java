package br.com.fiap.FarmaNear_Register.domain;

import lombok.Getter;

@Getter
public class Drugstore {
    private final Integer cnpj;
    private final String name;
    private final String email;
    private final String password;
    private final String phone;
    private final Address address;

    public Drugstore(Integer cnpj, String name, String email, String password, String phone, Address address) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
