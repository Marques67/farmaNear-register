package br.com.fiap.FarmaNear_Register.infra.config;

import br.com.fiap.FarmaNear_Register.controller.dto.QueueDrugstoreData;
import br.com.fiap.FarmaNear_Register.infra.gateway.QueueGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class QueueConfig {

    @Bean
    public QueueGateway queueGateway(KafkaTemplate<String, QueueDrugstoreData> kafkaTemplate) {
        return new QueueGateway(kafkaTemplate);
    }
}
