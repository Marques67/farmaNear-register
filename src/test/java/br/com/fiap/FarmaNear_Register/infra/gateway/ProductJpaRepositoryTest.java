package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.entities.product.Product;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
                "10mg", "Comprimido", LocalDate.now(), "6865b4254de003cf9bc1aac2");

        Product product = new Product("111", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "6865b4254de003cf9bc1aac2");

        ProductDto productDto = new ProductDto("1L", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "6865b4254de003cf9bc1aac2");

        Mockito.when(productRepository.save(Mockito.any(ProductEntity.class))).thenReturn(productEntity);

        ProductDto result = productJpaRepository.saveProduct(productDto);

        assertNotNull(result.id());
        assertEquals(productEntity.getName(), result.name());
        assertEquals(productEntity.getBrand(), result.brand());
        assertEquals(productEntity.getQuantity(), result.quantity());
        assertEquals(productEntity.getDosage(), result.dosage());
        assertEquals(productEntity.getType(), result.type());
        assertEquals(productEntity.getExpirationDate(), result.expirationDate());
        assertEquals(productEntity.getDrugstoreId(), new ObjectId(result.drugstoreId()));
    }

    @Test
    void shouldSaveAListOfProductsWithSuccess() {
        ProductEntity productEntity = new ProductEntity("1L", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "6865b4254de003cf9bc1aac2");

        ProductDto productDto = new ProductDto("1L", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "6865b4254de003cf9bc1aac2");

        Mockito.when(productRepository.save(Mockito.any(ProductEntity.class))).thenReturn(productEntity);

        List<ProductDto> resultList = productJpaRepository.saveProducts(List.of(productDto));

        assertNotNull(resultList);
        assertEquals(productEntity.getName(), resultList.get(0).name());
        assertEquals(productEntity.getBrand(), resultList.get(0).brand());
        assertEquals(productEntity.getQuantity(), resultList.get(0).quantity());
        assertEquals(productEntity.getDosage(), resultList.get(0).dosage());
        assertEquals(productEntity.getType(), resultList.get(0).type());
        assertEquals(productEntity.getExpirationDate(), resultList.get(0).expirationDate());
        assertEquals(productEntity.getDrugstoreId(), new ObjectId(resultList.get(0).drugstoreId()));
    }

}