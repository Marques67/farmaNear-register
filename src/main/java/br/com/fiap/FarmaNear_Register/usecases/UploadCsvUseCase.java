package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductCsvDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class UploadCsvUseCase {

    private final IProductJpaGateway productJpaGateway;

    public UploadCsvUseCase(IProductJpaGateway productJpaGateway) {
        this.productJpaGateway = productJpaGateway;
    }

    public List<ProductDto> uploadCsv(MultipartFile file) throws IOException {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file. Submit a CSV.");
        }

        List<ProductCsvDto> csvProducts = new CsvToBeanBuilder<ProductCsvDto>(new InputStreamReader(file.getInputStream()))
                .withType(ProductCsvDto.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();

        List<ProductDto> productList = csvProducts.stream()
                .map(p -> new ProductDto(
                        null,
                        p.getName(),
                        p.getBrand(),
                        p.getQuantity(),
                        p.getDosage(),
                        p.getType(),
                        p.getExpirationDate(),
                        p.getDrugstoreId()
                ))
                .collect(Collectors.toList());

        productJpaGateway.saveProducts(productList);

        return productList;
    }
}
