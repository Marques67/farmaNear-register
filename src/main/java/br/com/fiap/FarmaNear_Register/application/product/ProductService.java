package br.com.fiap.FarmaNear_Register.application.product;

import br.com.fiap.FarmaNear_Register.application.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.domain.product.Product;
import br.com.fiap.FarmaNear_Register.infra.product.ProductEntity;
import br.com.fiap.FarmaNear_Register.infra.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<ProductDto> saveProduct(List<ProductDto> productList) {
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
                productDto.dosage(), productDto.type(), productDto.expirationDate());

        ProductEntity productEntity = repository.save(product.saveProduct());

        return new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getBrand(),
                productEntity.getQuantity(), productEntity.getDosage(), productEntity.getType(), productEntity.getExpirationDate());

    }
}
