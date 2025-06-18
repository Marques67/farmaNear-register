package br.com.fiap.FarmaNear_Register.usecases;

import br.com.fiap.FarmaNear_Register.interfaces.IDrugstoreJpaGateway;
import org.springframework.web.multipart.MultipartFile;

public class UploadCsvUseCase {

    private final IDrugstoreJpaGateway drugstoreJpaGateway;

    public MultipartFile UploadCsv(MultipartFile file) {

        //TODO application business here

        return file;
    }
}
