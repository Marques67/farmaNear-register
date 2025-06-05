package br.com.fiap.FarmaNear_Register.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugstoreRepository extends JpaRepository<DrugstoreEntity, Long> {
}
