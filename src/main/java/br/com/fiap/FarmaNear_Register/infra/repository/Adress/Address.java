package br.com.fiap.FarmaNear_Register.infra.repository.Adress;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;


    public Address(Long id, String street, String number, String complement, String city, String state, String zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address() {

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

