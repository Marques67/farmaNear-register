package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.QueueDrugstoreData;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;
import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;
import br.com.fiap.FarmaNear_Register.interfaces.IQueueGateway;

import java.util.Optional;

public class CreateDrugstoreUseCase {

    private final IDrugstoreJpaGateway drugstoreJpaGateway;
    private final IQueueGateway queueGateway;

    public CreateDrugstoreUseCase(IDrugstoreJpaGateway drugstoreJpaGateway, IQueueGateway kafkaGateway) {
        this.drugstoreJpaGateway = drugstoreJpaGateway;
        this.queueGateway = kafkaGateway;
    }

    public DrugstoreDto createDrugstore(InsertDrugstoreDto insertDrugstoreDto) {
        Optional<DrugstoreEntity> drugstoreEntityOptional = drugstoreJpaGateway.getDrugstoreByCnpj(insertDrugstoreDto.cnpj());

        if (drugstoreEntityOptional.isPresent()) {
            throw new RuntimeException("Drugstore with this cnpj already exist");
        }

        var drugstore = drugstoreJpaGateway.createDrugstore(insertDrugstoreDto);

        queueGateway.sendDrugstoreToQueue(new QueueDrugstoreData(insertDrugstoreDto.cnpj(), insertDrugstoreDto.address()));

        return drugstore;
    }
}
