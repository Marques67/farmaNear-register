package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.usecases.UploadCsvUseCase;
import org.springframework.web.multipart.MultipartFile;

public class UploadCsvController {

    private final UploadCsvUseCase uploadCsvUseCase;

    public UploadCsvController(UploadCsvUseCase uploadCsvUseCase) {
        this.uploadCsvUseCase = uploadCsvUseCase;
    }

    public MultipartFile UploadCsv(MultipartFile file) {
        return this.uploadCsvUseCase.UploadCsv(file);
    }
}
