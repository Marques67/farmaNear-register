package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.GetDrugstoreController;
import br.com.fiap.FarmaNear_Register.controller.dto.GetDrugstoreDataDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.gateway.DrugstoreJpaRepository;
import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.usecases.CreateDrugstoreUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final CreateDrugstoreUseCase createDrugstoreUseCase;
    private final GetDrugstoreController getDrugstoreController;

    public RegisterController(CreateDrugstoreUseCase createDrugstoreUseCase, GetDrugstoreController getDrugstoreController) {
        this.createDrugstoreUseCase = createDrugstoreUseCase;
        this.getDrugstoreController = getDrugstoreController;
    }

    @PostMapping("/drugstore")
    public ResponseEntity<?> createDrugstore(@RequestBody InsertDrugstoreDto insertDrugstoreDto) {
        try {
            return ResponseEntity.ok(createDrugstoreUseCase.createDrugstore(insertDrugstoreDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping()
    public ResponseEntity<GetDrugstoreDataDto> getAllDrugstore(@RequestParam String cnpj) {
        return ResponseEntity.ok(getDrugstoreController.getDrugstore(cnpj));
    }
}
