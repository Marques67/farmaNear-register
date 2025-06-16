package br.com.fiap.FarmaNear_Register.infra.repository.drugstore;

import br.com.fiap.FarmaNear_Register.infra.repository.Adress.Address;
import br.com.fiap.FarmaNear_Register.infra.repository.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("drugstore")
@Getter
public class Drugstore {

    @Id
    private Long id;
    private Integer cnpj;
    private String name;
    private String email;
    private String phone;
    private Address address;
    private Set<Product> products;

    public Drugstore() {
    }

    public Drugstore(Long id, Integer cnpj, String name, String email, String phone, Address address, Set<Product> products) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.products = products;
    }
}
