package br.com.fiap.FarmaNear_Register.infra.repository.address;

public class AddressEntity {

    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipCode;

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
}

