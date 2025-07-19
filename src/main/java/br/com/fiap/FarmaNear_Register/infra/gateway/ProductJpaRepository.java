package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.entities.product.Product;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductRepository;
import br.com.fiap.FarmaNear_Register.interfaces.IProductJpaGateway;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductJpaRepository implements IProductJpaGateway {

    private final MongoTemplate mongoTemplate;
    private final ProductRepository repository;

    public ProductJpaRepository(ProductRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<ProductDto> saveProducts(List<ProductDto> productList) {
        List<ProductDto> productsDtoSaved = new ArrayList<>();

        productList.forEach(productDto -> {
            ProductDto productSaved = saveProduct(productDto);
            productsDtoSaved.add(productSaved);
        });

        return productsDtoSaved;
    }

    public ProductDto saveProduct(ProductDto productDto) {

        Product product = new Product(productDto.name(), productDto.brand(), productDto.quantity(),
                productDto.dosage(), productDto.type(), productDto.expirationDate(), productDto.drugstoreCnpj(),
                productDto.price());

        ProductEntity productEntity = repository.save(product.saveProduct());

        return new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getBrand(),
                productEntity.getQuantity(), productEntity.getDosage(), productEntity.getType(), productEntity.getExpirationDate(),
                productEntity.getDrugstoreCnpj(), productEntity.getPrice());
    }

    public List<DrugstoreEntity> getDrugstoreByProduct(String productName) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("name").is(productName)),
                Aggregation.lookup("drugstore", "drugstorecnpj", "_id", "drugstore"),
                Aggregation.unwind("drugstore"),
                Aggregation.replaceRoot("drugstore"));

        return mongoTemplate.aggregate(aggregation, "product", DrugstoreEntity.class)
                .getMappedResults();
    }

    public List<GetProductDataDto> getProducts(String productName) {
        var productsEntities = repository.findAllByName(productName);

        return productsEntities.stream().map(GetProductDataDto::new).toList();
    }

    public List<GetProductDataDto> getProductsByCnpj(String cnpj) {
        var productsEntities = repository.findAllByDrugstoreCnpj(cnpj);

        return productsEntities.stream().map(GetProductDataDto::new).toList();
    }
}
