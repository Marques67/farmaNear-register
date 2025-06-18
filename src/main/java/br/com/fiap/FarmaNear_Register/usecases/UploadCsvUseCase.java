package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UploadCsvUseCase {

    private final IProductJpaGateway productJpaGateway;

    public UploadCsvUseCase(IProductJpaGateway productJpaGateway) {
        this.productJpaGateway = productJpaGateway;
    }

    public List<ProductDto> uploadCsv(MultipartFile file) throws IOException {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file. Submit a CSV.");
        }

        List<ProductDto> productList = new CsvToBeanBuilder<ProductDto>(new InputStreamReader(file.getInputStream()))
                .withType(ProductDto.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();

        productJpaGateway.saveProducts(productList);

        return productList;
    }
}
