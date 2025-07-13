package br.com.fiap.FarmaNear_Register.infra.repository.drugstore;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugstoreRepository extends MongoRepository<DrugstoreEntity, Long> {

    Optional<DrugstoreEntity> findByCnpj(String cnpj);
}
