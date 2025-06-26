package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.entities.product.Product;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductJpaRepositoryTest {

    @InjectMocks
    private ProductJpaRepository productJpaRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveNewProductWithSuccess() {
        ProductEntity productEntity = new ProductEntity("111", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "1L");

        Product product = new Product("111", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "1L");

        ProductDto productDto = new ProductDto("1L", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "1L");

        Mockito.when(productRepository.save(product.saveProduct())).thenReturn(productEntity);

        ProductDto result = productJpaRepository.saveProduct(productDto);

        assertNotNull(result.id());
        assertEquals(productEntity.getName(), result.name());
        assertEquals(productEntity.getBrand(), result.brand());
        assertEquals(productEntity.getQuantity(), result.quantity());
        assertEquals(productEntity.getDosage(), result.dosage());
        assertEquals(productEntity.getType(), result.type());
        assertEquals(productEntity.getExpirationDate(), result.expirationDate());
        assertEquals(productEntity.getDrugstoreId(), result.drugstoreId());
    }

    @Test
    void shouldSaveAListOfProductsWithSuccess() {
        ProductEntity productEntity = new ProductEntity("1L", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "1L");

        ProductDto productDto = new ProductDto("1L", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "1L");

        Mockito.when(productRepository.save(productEntity)).thenReturn(productEntity);

        List<ProductDto> resultList = productJpaRepository.saveProducts(List.of(productDto));

        assertNotNull(resultList);
        assertEquals(productEntity.getName(), resultList.get(1).name());
        assertEquals(productEntity.getBrand(), resultList.get(1).brand());
        assertEquals(productEntity.getQuantity(), resultList.get(1).quantity());
        assertEquals(productEntity.getDosage(), resultList.get(1).dosage());
        assertEquals(productEntity.getType(), resultList.get(1).type());
        assertEquals(productEntity.getExpirationDate(), resultList.get(1).expirationDate());
        assertEquals(productEntity.getDrugstoreId(), resultList.get(1).drugstoreId());
    }

}