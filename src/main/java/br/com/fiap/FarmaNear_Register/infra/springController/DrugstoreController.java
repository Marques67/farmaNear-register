package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.GetDrugstoreController;
import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.usecases.CreateDrugstoreUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drugstore")
public class DrugstoreController {

    private final CreateDrugstoreUseCase createDrugstoreUseCase;
    private final GetDrugstoreController getDrugstoreController;

    public DrugstoreController(CreateDrugstoreUseCase createDrugstoreUseCase, GetDrugstoreController getDrugstoreController) {
        this.createDrugstoreUseCase = createDrugstoreUseCase;
        this.getDrugstoreController = getDrugstoreController;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createDrugstore(@RequestBody InsertDrugstoreDto insertDrugstoreDto) {
        try {
            return ResponseEntity.ok(createDrugstoreUseCase.createDrugstore(insertDrugstoreDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<GetDrugstoreDataDto> getDrugstore(@RequestParam String cnpj) {
        return ResponseEntity.ok(getDrugstoreController.getDrugstore(cnpj));
    }
}
