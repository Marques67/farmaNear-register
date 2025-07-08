package br.com.fiap.FarmaNear_Register.infra.repository.product;

import org.springframework.data.annotation.Id;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Objects;

@Document("product")
@NoArgsConstructor
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String brand;
    private Integer quantity;
    private String dosage;
    private String type;

    private LocalDate expirationDate;

    @Field("drugstore_cnpj")
    private Long drugstoreCnpj;

    private Double price;

    public ProductEntity(String id, String name, String brand, Integer quantity, String dosage, String type,
                         LocalDate expirationDate, Long drugstoreCnpj, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
        this.drugstoreCnpj = drugstoreCnpj;
        this.price = price;
    }

    public ProductEntity(String name, String brand, Integer quantity, String dosage, String type, LocalDate expirationDate,
                         Long drugstoreCnpj, Double price) {
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.dosage = dosage;
        this.type = type;
        this.expirationDate = expirationDate;
        this.drugstoreCnpj = drugstoreCnpj;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(brand, that.brand)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(dosage, that.dosage)
                && Objects.equals(type, that.type)
                && Objects.equals(expirationDate, that.expirationDate)
                && Objects.equals(drugstoreCnpj, that.drugstoreCnpj)
                && Objects.equals(price, that.price);
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public String getId() {
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

    public Long getDrugstoreCnpj() {
        return drugstoreCnpj;
    }

    public Double getPrice() {
        return price;
    }
}
