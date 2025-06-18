package br.com.fiap.FarmaNear_Register.infra.repository.drugstore;

import br.com.fiap.FarmaNear_Register.infra.repository.Adress.AddressEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("drugstore")
@Getter
public class DrugstoreEntity {

    @Id
    private Long id;
    private Integer cnpj;
    private String name;
    private String email;
    private String phone;
    private AddressEntity address;
    private Set<ProductEntity> products;

    public DrugstoreEntity() {
    }

    public DrugstoreEntity(Long id, Integer cnpj, String name, String email, String phone, AddressEntity address, Set<ProductEntity> products) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.products = products;
    }
}
