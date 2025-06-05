package br.com.fiap.FarmaNear_Register.application;

import br.com.fiap.FarmaNear_Register.application.dto.DrugstoreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final DrugstoreService drugstoreService;

    public RegisterController(DrugstoreService drugstoreService) {
        this.drugstoreService = drugstoreService;
    }

    @PostMapping("/drugstore")
    public ResponseEntity<?> createDrugstore(@RequestBody DrugstoreDto drugstoreDto) {
        drugstoreService.createDrugstore(drugstoreDto);

        return ResponseEntity.ok("Drugstore registered successfully");
    }
}
