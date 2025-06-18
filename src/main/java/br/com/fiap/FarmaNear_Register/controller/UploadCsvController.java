package br.com.fiap.FarmaNear_Register.controller;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;
import br.com.fiap.FarmaNear_Register.usecases.UploadCsvUseCase;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class UploadCsvController {

    private final UploadCsvUseCase uploadCsvUseCase;

    public UploadCsvController(UploadCsvUseCase uploadCsvUseCase) {
        this.uploadCsvUseCase = uploadCsvUseCase;
    }

    public List<ProductDto> uploadCsv(MultipartFile file) throws IOException {
        return this.uploadCsvUseCase.uploadCsv(file);
    }
}
