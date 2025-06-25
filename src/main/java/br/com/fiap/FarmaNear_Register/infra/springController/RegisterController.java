package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
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

    private final DrugstoreJpaRepository drugstoreJpaRepository;

    public RegisterController(DrugstoreJpaRepository drugstoreJpaRepository) {
        this.drugstoreJpaRepository = drugstoreJpaRepository;
    }

    @PostMapping("/drugstore")
    public ResponseEntity<DrugstoreDto> createDrugstore(@RequestBody InsertDrugstoreDto insertDrugstoreDto) {
        return ResponseEntity.ok(drugstoreJpaRepository.createDrugstore(insertDrugstoreDto));
    }
}
