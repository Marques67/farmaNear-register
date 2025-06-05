package br.com.fiap.FarmaNear_Register.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class DrugstoreEntity {

    @Id
    private Long id;
    private Integer cnpj;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Long addressId;

    public DrugstoreEntity() {}

    public DrugstoreEntity(Long id, Integer cnpj, String name, String email, String password, String phone, Long addressId) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.addressId = addressId;
    }
}
