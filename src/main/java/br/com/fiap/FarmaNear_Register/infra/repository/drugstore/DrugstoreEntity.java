package br.com.fiap.FarmaNear_Register.infra.repository.drugstore;

import br.com.fiap.FarmaNear_Register.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("drugstore")
public class DrugstoreEntity {

    @Id
    private String id;
    private Long cnpj;
    private String name;
    private String email;
    private String phone;
    private AddressEntity address;
    private Set<ProductEntity> products;

    public DrugstoreEntity() {
    }

    public DrugstoreEntity(String id, Long cnpj, String name, String email, String phone, AddressEntity address) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public DrugstoreEntity(Long cnpj, String name, String email, String phone, AddressEntity address) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public DrugstoreEntity(String id, Long cnpj, String name, String email, String phone, AddressEntity address, Set<ProductEntity> products) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public Long getCnpj() {
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
