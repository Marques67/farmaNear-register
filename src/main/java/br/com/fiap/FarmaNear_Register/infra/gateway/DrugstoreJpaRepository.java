package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreRepository;
import org.springframework.stereotype.Service;

@Service
public class DrugstoreJpaRepository {

    private final DrugstoreRepository drugstoreRepository;

    public DrugstoreJpaRepository(DrugstoreRepository drugstoreRepository) {
        this.drugstoreRepository = drugstoreRepository;
    }

    public DrugstoreDto createDrugstore(DrugstoreDto drugstoreDto) {
       //Tem que fazer as coisas ainda

        return drugstoreDto;
    }
}
