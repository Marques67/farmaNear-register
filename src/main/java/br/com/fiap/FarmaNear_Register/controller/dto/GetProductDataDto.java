package br.com.fiap.FarmaNear_Register.controller.dto;

import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public record GetProductDataDto(String name, String brand, Integer quantity, String dosage, String type,
                                LocalDate expirationDate, ObjectId drugstoreId) {
    public GetProductDataDto(ProductEntity product) {
        this(product.getName(), product.getBrand(), product.getQuantity(), product.getDosage(), product.getType(), product.getExpirationDate(), product.getDrugstoreId());
    }
}
