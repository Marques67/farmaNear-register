package br.com.fiap.FarmaNear_Register.interfaces;

import br.com.fiap.FarmaNear_Register.controller.dto.QueueDrugstoreData;

public interface IQueueGateway {

    void sendDrugstoreToQueue(QueueDrugstoreData queueDrugstoreData);
}
