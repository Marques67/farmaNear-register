package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.infra.gateway.DrugstoreJpaRepository;
import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final DrugstoreJpaRepository drugstoreService;

    public RegisterController(DrugstoreJpaRepository drugstoreService) {
        this.drugstoreService = drugstoreService;
    }

    @PostMapping("/drugstore")
    public ResponseEntity<DrugstoreDto> createDrugstore(@RequestBody DrugstoreDto drugstoreDto) {
        drugstoreService.createDrugstore(drugstoreDto);
        return ResponseEntity.ok("DrugstoreEntity registered successfully");
    }
}
