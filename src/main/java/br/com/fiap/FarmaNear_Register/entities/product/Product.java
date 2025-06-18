package br.com.fiap.FarmaNear_Register.entities.product;

import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;

import java.time.LocalDate;

public class Product implements ProductEntityInterface {

    private Long id;
    private String name;
    private String brand;
    private Integer quantity;
    private String dosage;
    private String type;
    private LocalDate expirationDate;
    private Long drugstoreId;

    public Product(Long id, String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public Product(String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate,
                   Long drugstoreId) {
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
        this.drugstoreId = drugstoreId;
    }

    public Long getId() {
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

    @Override
    public ProductEntity saveProduct() {
        return new ProductEntity(name, brand, quantity, dosage, type, expirationDate, drugstoreId);
    }
}
