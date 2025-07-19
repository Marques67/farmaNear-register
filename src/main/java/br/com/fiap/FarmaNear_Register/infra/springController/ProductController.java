package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.*;
import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import org.springframework.http.HttpStatus;
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
    private final GetDrugstoreByProductController getDrugstoreByProductController;
    private final GetProductsController getProductsController;
    private final GetProductsByCnpjController getProductsByCnpjController;

    public ProductController(UploadCsvController uploadCsvController, InsertNewProductController insertNewProductController,
                             GetDrugstoreByProductController getProductController, GetProductsController getProductsController,
                             GetProductsByCnpjController getProductsByCnpjController) {
        this.uploadCsvController = uploadCsvController;
        this.insertNewProductController = insertNewProductController;
        this.getDrugstoreByProductController = getProductController;
        this.getProductsController = getProductsController;
        this.getProductsByCnpjController = getProductsByCnpjController;
    }

    @PostMapping(value = "/upload-csv/{drugstoreCnpj}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadCsv(@RequestParam("file") MultipartFile file,
                                       @PathVariable String drugstoreCnpj) throws Exception {
        try {
            return ResponseEntity.ok(uploadCsvController.uploadCsv(file, drugstoreCnpj));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> importNewProduct(@RequestBody ProductDto productDto) {
        try {
            return ResponseEntity.ok(insertNewProductController.insertNewProduct(productDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/getDrugstoreByProduct")
    public ResponseEntity<?> getDrugstoreByProduct(@RequestParam String productName) {
        try {
            return ResponseEntity.ok(getDrugstoreByProductController.getDrugstoreByProduct(productName));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<GetProductDataDto>> getProducts(@RequestBody String productName) {
        return ResponseEntity.ok(getProductsController.getProducts(productName));
    }

    @GetMapping("/getProductsByCnpj")
    public ResponseEntity<List<GetProductDataDto>> getProductsByCnpj(@RequestParam String cnpj) {
        return ResponseEntity.ok(getProductsByCnpjController.getProducts(cnpj));
    }
}
