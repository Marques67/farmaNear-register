package br.com.fiap.FarmaNear_Register.entities.product;

import br.com.fiap.FarmaNear_Register.infra.repository.product.Product;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductBuilder;

import java.time.LocalDate;

public class ProductEntity implements ProductEntityInterface {

    private Long id;
    private String name;
    private String brand;
    private Integer quantity;
    private String dosage;
    private String type;
    private LocalDate expirationDate;

    public ProductEntity(Long id, String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public ProductEntity(String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate) {
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
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
    public Product saveProduct() {
        return new ProductBuilder()
                .withId(id)
                .withName(name)
                .withBrand(brand)
                .withQuantity(quantity)
                .withDosage(dosage)
                .withType(type)
                .withExpirationDate(expirationDate)
                .build();
    }
}
