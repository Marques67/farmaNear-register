package br.com.fiap.FarmaNear_Register.controller.dto;

import java.time.LocalDate;

public record ProductDto(String id, String name, String brand, Integer quantity, String dosage, String type,
                         LocalDate expirationDate, String drugstoreId) {
}
