package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;

public class InsertNewProductUseCase {

    private final IProductJpaGateway productJpaGateway;

    private final GetDrugstoreUseCase getDrugstoreUseCase;

    public InsertNewProductUseCase(IProductJpaGateway productJpaGateway, GetDrugstoreUseCase getDrugstoreUseCase) {
        this.productJpaGateway = productJpaGateway;
        this.getDrugstoreUseCase = getDrugstoreUseCase;
    }

    public ProductDto insertNewProduct(ProductDto productDto) {
        getDrugstoreUseCase.getDrugstore(productDto.drugstoreCnpj());
        return productJpaGateway.saveProduct(productDto);
    }
}
