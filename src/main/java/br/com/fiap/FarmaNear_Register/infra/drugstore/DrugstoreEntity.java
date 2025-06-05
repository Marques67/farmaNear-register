package br.com.fiap.FarmaNear_Register.infra.drugstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name = "drugstore")
@Getter
public class DrugstoreEntity {

    @Id
    private Long id;
    private Integer cnpj;
    private String name;
    private String email;
    private String phone;

    @Column(name = "address_id")
    private Long addressId;

    public DrugstoreEntity() {
    }

    public DrugstoreEntity(Long id, Integer cnpj, String name, String email, String phone, Long addressId) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addressId = addressId;
    }
}
