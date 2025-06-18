package br.com.fiap.FarmaNear_Register.entities.drugstore;

import br.com.fiap.FarmaNear_Register.entities.address.Address;
import br.com.fiap.FarmaNear_Register.entities.product.Product;

import java.util.Set;

public class Drugstore {
    private final Integer cnpj;
    private final String name;
    private final String email;
    private final String phone;
    private final Address address;
    private final Set<Product> products;

    public Drugstore(Integer cnpj, String name, String email, String phone, Address address, Set<Product> products) {
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

    public Address getAddress() {
        return address;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
