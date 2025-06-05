package br.com.fiap.FarmaNear_Register.domain.drugstore;

import br.com.fiap.FarmaNear_Register.domain.address.Address;
import lombok.Getter;

@Getter
public class Drugstore {
    private final Integer cnpj;
    private final String name;
    private final String email;
    private final String phone;
    private final Address address;

    public Drugstore(Integer cnpj, String name, String email, String phone, Address address) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
