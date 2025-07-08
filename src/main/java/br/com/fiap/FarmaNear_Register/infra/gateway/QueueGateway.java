package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.QueueDrugstoreData;
import br.com.fiap.FarmaNear_Register.interfaces.IQueueGateway;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class QueueGateway implements IQueueGateway {

    private final KafkaTemplate<String, QueueDrugstoreData> kafkaTemplate;

    public QueueGateway(KafkaTemplate<String, QueueDrugstoreData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendDrugstoreToQueue(QueueDrugstoreData queueDrugstoreData) {
        try{
            Future<?> future = kafkaTemplate.send("drugstore-data", queueDrugstoreData);

            future.get();
        }catch(ExecutionException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
