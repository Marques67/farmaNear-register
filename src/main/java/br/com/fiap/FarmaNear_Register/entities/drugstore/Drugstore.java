package br.com.fiap.FarmaNear_Register.entities.drugstore;

import br.com.fiap.FarmaNear_Register.entities.address.Address;
import br.com.fiap.FarmaNear_Register.entities.product.Product;
import br.com.fiap.FarmaNear_Register.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;

import java.util.Set;

public class Drugstore implements DrugstoreEntityInterface {
    private final String cnpj;
    private final String name;
    private final String email;
    private final String phone;
    private final Address address;
    private Set<Product> products;

    public Drugstore(String cnpj, String name, String email, String phone, Address address) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Drugstore(String cnpj, String name, String email, String phone, Address address, Set<Product> products) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.products = products;
    }

    public String getCnpj() {
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

    @Override
    public DrugstoreEntity createDrugstore() {
        AddressEntity addressEntity = new AddressEntity(address.getStreet(), address.getNumber(), address.getComplement(),
                address.getCity(), address.getState(), address.getZipCode());
        return new DrugstoreEntity(cnpj, name, email, phone, addressEntity);
    }
}
