package br.com.fiap.FarmaNear_Register.infra.repository.Adress;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressEntity, Long> {
}
