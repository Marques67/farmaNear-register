package br.com.fiap.FarmaNear_Register.entities.product;

import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;

import java.time.LocalDate;

public class Product implements ProductEntityInterface {

    private String id;
    private String name;
    private String brand;
    private Integer quantity;
    private String dosage;
    private String type;
    private LocalDate expirationDate;
    private String drugstoreCnpj;
    private Double price;

    public Product(String id, String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate,
                   String drugstoreCnpj, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
        this.drugstoreCnpj = drugstoreCnpj;
        this.price = price;
    }

    public Product(String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate,
                   String drugstoreCnpj, Double price) {
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
        this.drugstoreCnpj = drugstoreCnpj;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDosage() {
        return dosage;
    }

    public String getType() {
        return type;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public ProductEntity saveProduct() {
        return new ProductEntity(name, brand, quantity, dosage, type, expirationDate, drugstoreCnpj, price);
    }
}
