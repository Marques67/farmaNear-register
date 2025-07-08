package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.any;

public class UploadCsvUseCaseTest {

    @Mock
    private IProductJpaGateway productJpaGateway;

    @InjectMocks
    private UploadCsvUseCase uploadCsvUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUploadCsv_validFile_shouldParseAndSaveProducts() throws IOException {
        String csvContent = String.join("\n",
                "name;brand;quantity;dosage;type;expirationDate;price",
                "Dorflex;Dorflex;10;10mg;Comprimido;2025-12-31;3.86",
                "Paracetamol;Medley;10;750mg;Antitérmico;2026-01-15;4.00"
        );
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "products.csv",
                "text/csv",
                csvContent.getBytes(StandardCharsets.UTF_8)
        );

        ProductDto product1 = new ProductDto("111", "Dorflex", "Dorflex", 10,
                "10mg", "Comprimido", LocalDate.of(2025, 12, 31),
                686543L, 3.86);
        ProductDto product2 = new ProductDto("222", "Paracetamol", "Medley", 10,
                "750mg", "Antitérmico", LocalDate.of(2026, 01, 15),
                686543L, 4.00);
        List<ProductDto> expectedProducts = List.of(product1, product2);

        Mockito.when(productJpaGateway.saveProducts(any())).thenReturn(List.of());

        List<ProductDto> result = uploadCsvUseCase.uploadCsv(file, 686543L);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Dorflex", result.get(0).name());
        Assertions.assertEquals("Paracetamol", result.get(1).name());
        Assertions.assertEquals(LocalDate.of(2025, 12, 31), result.get(0).expirationDate());

        Mockito.verify(productJpaGateway).saveProducts(anyList());
    }

    @Test
    void testUploadCsv_emptyFile_shouldThrowException() {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "products.csv",
                "text/csv",
                new byte[0]
        );

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            uploadCsvUseCase.uploadCsv(file, 686543L);
        });

        Assertions.assertEquals("Invalid file. Submit a CSV.", exception.getMessage());
        Mockito.verify(productJpaGateway, Mockito.never()).saveProducts(List.of());
    }

    @Test
    void testUploadCsv_invalidExtension_shouldThrowException() {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "products.txt",
                "text/plain",
                "name,price\nTest,10".getBytes(StandardCharsets.UTF_8)
        );

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            uploadCsvUseCase.uploadCsv(file, 686543L);
        });

        Assertions.assertEquals("Invalid file. Submit a CSV.", exception.getMessage());
        Mockito.verify(productJpaGateway, Mockito.never()).saveProducts(List.of());
    }
}
