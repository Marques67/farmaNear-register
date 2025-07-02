package br.com.fiap.FarmaNear_Register.interfaces;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.entities.product.Product;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;

import java.util.List;

public interface IProductJpaGateway {

    ProductDto saveProduct(ProductDto productDto);

    List<ProductDto> saveProducts(List<ProductDto> productDto);

    List<DrugstoreEntity> getDrugstoreByProduct(String productName);
}
