package br.com.fiap.FarmaNear_Register.controller.dto;

import br.com.fiap.FarmaNear_Register.utils.LocalDateConverterUtil;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.time.LocalDate;

public class ProductCsvDto {

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String brand;

    @CsvBindByName
    private Integer quantity;

    @CsvBindByName
    private String dosage;

    @CsvBindByName
    private String type;

    @CsvCustomBindByName(converter = LocalDateConverterUtil.class)
    private LocalDate expirationDate;

    @CsvBindByName
    private String drugstoreId;

    public ProductCsvDto() {}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getDosage() { return dosage; }

    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public LocalDate getExpirationDate() { return expirationDate; }

    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    public String getDrugstoreId() { return drugstoreId; }

    public void setDrugstoreId(String drugstoreId) { this.drugstoreId = drugstoreId; }
}
