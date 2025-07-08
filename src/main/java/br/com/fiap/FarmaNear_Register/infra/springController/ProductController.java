package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.GetDrugstoreByProductController;
import br.com.fiap.FarmaNear_Register.controller.GetProductsController;
import br.com.fiap.FarmaNear_Register.controller.InsertNewProductController;
import br.com.fiap.FarmaNear_Register.controller.UploadCsvController;
import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreByProductDto;
import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
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
    private final GetDrugstoreByProductController getDrugstoreByProductController;
    private final GetProductsController getProductsController;

    public ProductController(UploadCsvController uploadCsvController, InsertNewProductController insertNewProductController,
                             GetDrugstoreByProductController getProductController, GetProductsController getProductsController) {
        this.uploadCsvController = uploadCsvController;
        this.insertNewProductController = insertNewProductController;
        this.getDrugstoreByProductController = getProductController;
        this.getProductsController = getProductsController;
    }

    @PostMapping(value = "/upload-csv/{drugstoreCnpj}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<ProductDto> uploadCsv(@RequestParam("file") MultipartFile file,
                                      @PathVariable Long drugstoreCnpj) throws Exception {
        return uploadCsvController.uploadCsv(file, drugstoreCnpj);
    }

    @PostMapping
    public ResponseEntity<ProductDto> importNewProduct(@RequestBody ProductDto productDto) {
        ProductDto productSaved = insertNewProductController.insertNewProduct(productDto);
        return ResponseEntity.ok(productSaved);
    }

    @GetMapping
    public ResponseEntity<GetDrugstoreByProductDto> getDrugstoreByProduct(@RequestParam String productName) {
     return ResponseEntity.ok(getDrugstoreByProductController.getDrugstoreByProduct(productName));
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<GetProductDataDto>> getProducts(@RequestBody String productName) {
        return ResponseEntity.ok(getProductsController.getProducts(productName));
    }
}
