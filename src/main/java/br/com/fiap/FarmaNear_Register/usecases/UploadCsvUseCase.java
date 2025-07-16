package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductCsvDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UploadCsvUseCase {

    private final IProductJpaGateway productJpaGateway;

    private final GetDrugstoreUseCase getDrugstoreUseCase;

    public UploadCsvUseCase(IProductJpaGateway productJpaGateway, GetDrugstoreUseCase getDrugstoreUseCase) {
        this.productJpaGateway = productJpaGateway;
        this.getDrugstoreUseCase = getDrugstoreUseCase;
    }

    public List<ProductDto> uploadCsv(MultipartFile file, String cnpj) throws IOException {

        getDrugstoreUseCase.getDrugstore(cnpj);

        List<String> lines = transformFileInString(file);

        String csvContent = String.join("\n", lines);
        Reader cleanReader = new StringReader(csvContent);

        List<ProductCsvDto> csvProducts = new CsvToBeanBuilder<ProductCsvDto>(cleanReader)
                .withType(ProductCsvDto.class)
                .withSeparator(';')
                .withQuoteChar('"')
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
                        cnpj,
                        p.getPrice()
                ))
                .collect(Collectors.toList());

        return productJpaGateway.saveProducts(productList);
    }

    private static List<String> transformFileInString(MultipartFile file) throws IOException {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file. Submit a CSV.");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
        String firstLine = reader.readLine();

        if (firstLine != null && firstLine.startsWith("\uFEFF")) {
            firstLine = firstLine.substring(1);
        }

        List<String> lines = new ArrayList<>();
        lines.add(firstLine);
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}
