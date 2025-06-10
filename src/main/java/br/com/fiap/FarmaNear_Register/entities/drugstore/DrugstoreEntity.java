package br.com.fiap.FarmaNear_Register.entities.drugstore;

import br.com.fiap.FarmaNear_Register.entities.address.AddressEntity;
import lombok.Getter;

public class DrugstoreEntity {
    private final Integer cnpj;
    private final String name;
    private final String email;
    private final String phone;
    private final AddressEntity address;

    public DrugstoreEntity(Integer cnpj, String name, String email, String phone, AddressEntity address) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public AddressEntity getAddress() {
        return address;
    }
}
