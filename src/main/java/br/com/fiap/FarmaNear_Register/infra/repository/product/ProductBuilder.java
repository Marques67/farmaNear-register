package br.com.fiap.FarmaNear_Register.infra.repository.product;

import java.time.LocalDate;

public class ProductBuilder {

    private final Product productEntity = new Product();

    public ProductBuilder withId(Long id) {
        productEntity.setId(id);
        return this;
    }

    public ProductBuilder withName(String name) {
        productEntity.setName(name);
        return this;
    }

    public ProductBuilder withBrand(String brand) {
        productEntity.setBrand(brand);
        return this;
    }

    public ProductBuilder withQuantity(Integer quantity) {
        productEntity.setQuantity(quantity);
        return this;
    }

    public ProductBuilder withDosage(String dosage) {
        productEntity.setDosage(dosage);
        return this;
    }

    public ProductBuilder withType(String type) {
        productEntity.setType(type);
        return this;
    }

    public ProductBuilder withExpirationDate(LocalDate expirationDate) {
        productEntity.setExpirationDate(expirationDate);
        return this;
    }

    public Product build() {
        return productEntity;
    }
}
