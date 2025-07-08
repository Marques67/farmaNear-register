package br.com.fiap.FarmaNear_Register.controller.dto;

import br.com.fiap.FarmaNear_Register.utils.LocalDateConverterUtil;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.time.LocalDate;

public class ProductCsvDto {

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "brand")
    private String brand;

    @CsvBindByName(column = "quantity")
    private Integer quantity;

    @CsvBindByName(column = "dosage")
    private String dosage;

    @CsvBindByName(column = "type")
    private String type;

    @CsvCustomBindByName(converter = LocalDateConverterUtil.class)
    private LocalDate expirationDate;

    @CsvBindByName(column = "price")
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
