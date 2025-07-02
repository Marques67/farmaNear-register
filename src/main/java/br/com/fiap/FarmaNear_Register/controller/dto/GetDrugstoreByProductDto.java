package br.com.fiap.FarmaNear_Register.controller.dto;

import java.util.List;

public record GetDrugstoreByProductDto(String productName, List<DrugstoreDto> drugstores) {
}
