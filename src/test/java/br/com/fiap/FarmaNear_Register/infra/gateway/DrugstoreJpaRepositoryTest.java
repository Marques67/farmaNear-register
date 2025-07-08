package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.AddressDto;
import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreRepository;
import br.com.fiap.FarmaNear_Register.infra.repository.product.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DrugstoreJpaRepositoryTest {

    @InjectMocks
    private DrugstoreJpaRepository drugstoreJpaRepository;

    @Mock
    private DrugstoreRepository drugstoreRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateNewDrugstoreWithSuccess() {
        AddressEntity addressEntity = new AddressEntity("Rua Jose Bonifacio", "150", "Apto 201", "Rio de Janeiro",
                "Rio de Janeiro", "24440874");

        DrugstoreEntity drugstoreEntity = new DrugstoreEntity(111L, "Farm express", "farm.express@hotmail.com",
                "21 99988776655", addressEntity);

        AddressDto addressDto = new AddressDto("Rua Jose Bonifacio", "150", "Apto 201", "Rio de Janeiro",
                "Rio de Janeiro", "24440874");

        InsertDrugstoreDto insertDrugstoreDto = new InsertDrugstoreDto(70105796000122L, "Farm express", "farm.express@hotmail.com",
                "21 99988776655", addressDto);

        Mockito.when(drugstoreRepository.save(Mockito.any(DrugstoreEntity.class))).thenReturn(drugstoreEntity);

        DrugstoreDto result = drugstoreJpaRepository.createDrugstore(insertDrugstoreDto);

        assertEquals(drugstoreEntity.getCnpj(), result.cnpj());
        assertEquals(drugstoreEntity.getName(), result.name());
        assertEquals(drugstoreEntity.getEmail(), result.email());
        assertEquals(drugstoreEntity.getPhone(), result.phone());
    }

}