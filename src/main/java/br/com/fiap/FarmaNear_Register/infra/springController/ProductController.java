package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.infra.gateway.ProductJpaRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductJpaRepository service;

    public ProductController(ProductJpaRepository service) {
        this.service = service;
    }

    @PostMapping(value = "/upload-csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<ProductDto> uploadCsv(@RequestPart("file") MultipartFile file) throws Exception {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file. Submit a CSV.");
        }

        List<ProductDto> productList = new CsvToBeanBuilder<ProductDto>(new InputStreamReader(file.getInputStream()))
                .withType(ProductDto.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();

        return this.service.saveProduct(productList);
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveNewProduct(@RequestBody ProductDto productDto) {
        ProductDto productSaved = this.service.saveProduct(productDto);
        return ResponseEntity.ok(productSaved);
    }
}
