package br.com.fiap.FarmaNear_Register.infra.repository.address;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;

    public AddressEntity(Long id, String street, String number, String complement, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public AddressEntity(String street, String number, String complement, String city, String state, String zipCode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public AddressEntity() {

    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Long getId() {
        return id;
    }
}

