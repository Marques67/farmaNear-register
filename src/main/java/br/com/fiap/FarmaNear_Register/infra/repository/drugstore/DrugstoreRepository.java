package br.com.fiap.FarmaNear_Register.infra.repository.drugstore;

import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugstoreRepository extends MongoRepository<DrugstoreEntity, Long> {

    DrugstoreEntity findByCnpj(Long cnpj);
}
