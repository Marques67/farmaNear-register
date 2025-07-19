package br.com.fiap.FarmaNear_Register.infra.repository.product;

import br.com.fiap.FarmaNear_Register.controller.dto.GetProductDataDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByName(String name);

    List<ProductEntity> findAllByDrugstoreCnpj(String type);
}
