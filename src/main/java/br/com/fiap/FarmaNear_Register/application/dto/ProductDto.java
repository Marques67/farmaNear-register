package br.com.fiap.FarmaNear_Register.application.dto;

import java.time.LocalDate;

public record ProductDto(Long id, String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate) {
}
