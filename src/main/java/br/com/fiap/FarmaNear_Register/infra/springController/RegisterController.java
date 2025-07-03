package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.GetDrugstoreController;
import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.gateway.DrugstoreJpaRepository;
import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final DrugstoreJpaRepository drugstoreJpaRepository;
    private final GetDrugstoreController getDrugstoreController;

    public RegisterController(DrugstoreJpaRepository drugstoreJpaRepository, GetDrugstoreController getDrugstoreUseCase) {
        this.drugstoreJpaRepository = drugstoreJpaRepository;
        this.getDrugstoreController = getDrugstoreUseCase;
    }

    @PostMapping("/drugstore")
    public ResponseEntity<DrugstoreDto> createDrugstore(@RequestBody InsertDrugstoreDto insertDrugstoreDto) {
        return ResponseEntity.ok(drugstoreJpaRepository.createDrugstore(insertDrugstoreDto));
    }

    @GetMapping()
    public ResponseEntity<GetDrugstoreDataDto> getAllDrugstore(@RequestParam Long cnpj) {
        return ResponseEntity.ok(getDrugstoreController.getDrugstore(cnpj));
    }
}
