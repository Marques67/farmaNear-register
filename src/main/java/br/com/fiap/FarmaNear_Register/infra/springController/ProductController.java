package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.GetDrugstoreByProductController;
import br.com.fiap.FarmaNear_Register.controller.InsertNewProductController;
import br.com.fiap.FarmaNear_Register.controller.UploadCsvController;
import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreByProductDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final UploadCsvController uploadCsvController;
    private final InsertNewProductController insertNewProductController;
    private final GetDrugstoreByProductController getProductController;

    public ProductController(UploadCsvController uploadCsvController, InsertNewProductController insertNewProductController, GetDrugstoreByProductController getProductController) {
        this.uploadCsvController = uploadCsvController;
        this.insertNewProductController = insertNewProductController;
        this.getProductController = getProductController;
    }

    @PostMapping(value = "/upload-csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<ProductDto> uploadCsv(@RequestParam("file") MultipartFile file) throws Exception {
        return uploadCsvController.uploadCsv(file);
    }

    @PostMapping
    public ResponseEntity<ProductDto> importNewProduct(@RequestBody ProductDto productDto) {
        ProductDto productSaved = insertNewProductController.insertNewProduct(productDto);
        return ResponseEntity.ok(productSaved);
    }

    @GetMapping
    public ResponseEntity<GetDrugstoreByProductDto> getDrugstoreByProduct(@RequestParam String productName) {
     return ResponseEntity.ok(getProductController.getDrugstoreByProduct(productName));
    }
}
