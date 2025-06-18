package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.entities.product.Product;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductRepository;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductJpaRepository implements IProductJpaGateway {

    private final ProductRepository repository;

    public ProductJpaRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<ProductDto> saveProducts(List<ProductDto> productList) {
        List<ProductDto> productsDtoSaved = new ArrayList<>();

        productList.forEach(productDto -> {
            ProductDto productSaved = saveProduct(productDto);
            productsDtoSaved.add(productSaved);
        });

        return productsDtoSaved;
    }

    @Transactional
    public ProductDto saveProduct(ProductDto productDto) {

        Product product = new Product(productDto.name(), productDto.brand(), productDto.quantity(),
                productDto.dosage(), productDto.type(), productDto.expirationDate(), productDto.drugstoreId());

        ProductEntity productEntity = repository.save(product.saveProduct());

        return new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getBrand(),
                productEntity.getQuantity(), productEntity.getDosage(), productEntity.getType(), productEntity.getExpirationDate(),
                productEntity.getDrugstoreId());

    }
}
