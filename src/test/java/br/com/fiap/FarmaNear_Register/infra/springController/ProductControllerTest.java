package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.GetDrugstoreByProductController;
import br.com.fiap.FarmaNear_Register.controller.GetProductsController;
import br.com.fiap.FarmaNear_Register.controller.InsertNewProductController;
import br.com.fiap.FarmaNear_Register.controller.UploadCsvController;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.infra.gateway.ProductJpaRepository;
import br.com.fiap.FarmaNear_Register.utils.JsonFormatUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest {

    @Mock
    private ProductController productController;

    @Mock
    private UploadCsvController uploadCsvController;

    @Mock
    private InsertNewProductController insertNewProductController;

    @Mock
    GetDrugstoreByProductController getProductController;

    @Mock
    GetProductsController getProductsController;

    private MockMvc mockMvc;

    private AutoCloseable mock;

    @BeforeEach
    public void setup() {
        mock = MockitoAnnotations.openMocks(this);
        productController = new ProductController(uploadCsvController, insertNewProductController,
                getProductController, getProductsController);

        mockMvc = MockMvcBuilders
                .standaloneSetup(productController)
                .build();
    }

    @AfterEach
    public void close() throws Exception {
        mock.close();
    }

    @Test
    public void saveProduct() throws Exception {
        ProductDto productDto = new ProductDto("1L", "Dorflex - Relaxante muscular", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.now(), "6865654", 3.86);

        when(insertNewProductController.insertNewProduct(productDto)).thenReturn(productDto);

        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(productDto))
        ).andExpect(status().isOk());

        verify(insertNewProductController, times(1)).insertNewProduct(productDto);
    }

}