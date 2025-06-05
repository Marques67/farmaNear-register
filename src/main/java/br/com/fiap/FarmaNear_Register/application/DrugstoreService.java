package br.com.fiap.FarmaNear_Register.application;

import br.com.fiap.FarmaNear_Register.application.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.drugstore.DrugstoreRepository;
import org.springframework.stereotype.Service;

@Service
public class DrugstoreService {

    private final DrugstoreRepository drugstoreRepository;

    public DrugstoreService(DrugstoreRepository drugstoreRepository) {
        this.drugstoreRepository = drugstoreRepository;
    }

    public DrugstoreDto createDrugstore(DrugstoreDto drugstoreDto) {
       //Tem que fazer as coisas ainda

        return drugstoreDto;
    }
}
