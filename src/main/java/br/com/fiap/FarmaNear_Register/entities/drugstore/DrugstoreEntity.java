package br.com.fiap.FarmaNear_Register.entities.drugstore;

import br.com.fiap.FarmaNear_Register.entities.address.AddressEntity;
import br.com.fiap.FarmaNear_Register.entities.product.ProductEntity;

import java.util.Set;

public class DrugstoreEntity {
    private final Integer cnpj;
    private final String name;
    private final String email;
    private final String phone;
    private final AddressEntity address;
    private final Set<ProductEntity> products;

    public DrugstoreEntity(Integer cnpj, String name, String email, String phone, AddressEntity address, Set<ProductEntity> products) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.products = products;
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

    public Set<ProductEntity> getProducts() {
        return products;
    }
}
