package br.com.fiap.FarmaNear_Register.infra.repository.product;

import java.time.LocalDate;

public class ProductEntityBuilder {

    private final ProductEntity productEntity = new ProductEntity();

    public ProductEntityBuilder withId(Long id) {
        productEntity.setId(id);
        return this;
    }

    public ProductEntityBuilder withName(String name) {
        productEntity.setName(name);
        return this;
    }

    public ProductEntityBuilder withBrand(String brand) {
        productEntity.setBrand(brand);
        return this;
    }

    public ProductEntityBuilder withQuantity(Integer quantity) {
        productEntity.setQuantity(quantity);
        return this;
    }

    public ProductEntityBuilder withDosage(String dosage) {
        productEntity.setDosage(dosage);
        return this;
    }

    public ProductEntityBuilder withType(String type) {
        productEntity.setType(type);
        return this;
    }

    public ProductEntityBuilder withExpirationDate(LocalDate expirationDate) {
        productEntity.setExpirationDate(expirationDate);
        return this;
    }

    public ProductEntity build() {
        return productEntity;
    }
}
