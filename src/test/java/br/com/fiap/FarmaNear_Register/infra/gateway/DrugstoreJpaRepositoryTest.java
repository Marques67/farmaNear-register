package br.com.fiap.FarmaNear_Register.infra.gateway;

import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.repository.address.AddressEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreEntity;
import br.com.fiap.FarmaNear_Register.infra.repository.drugstore.DrugstoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DrugstoreJpaRepositoryTest {

    private DrugstoreJpaRepository drugstoreJpaRepository;

    @Autowired
    private DrugstoreRepository drugstoreRepository;

    @BeforeEach
    void setUp() {
        drugstoreJpaRepository = new DrugstoreJpaRepository(drugstoreRepository);
    }

    @Test
    void shouldCreateNewDrugstoreWithSuccess() {
        AddressEntity addressEntity = new AddressEntity("Rua Jose Bonifacio", "150", "Apto 201", "Rio de Janeiro",
                "Rio de Janeiro", "24440874");

        DrugstoreEntity drugstoreEntity = new DrugstoreEntity(1L, 70105796000122L, "Farm express", "farm.express@hotmail.com",
                "21 99988776655", addressEntity);

        InsertDrugstoreDto insertDrugstoreDto = new InsertDrugstoreDto(70105796000122L, "Farm express", "farm.express@hotmail.com",
                "21 99988776655");

        Mockito.when(drugstoreRepository.save(drugstoreEntity)).thenReturn(drugstoreEntity);

        DrugstoreDto result = drugstoreJpaRepository.createDrugstore(insertDrugstoreDto);

        assertNotNull(result.id());
        assertEquals(drugstoreEntity.getCnpj(), result.cnpj());
        assertEquals(drugstoreEntity.getName(), result.name());
        assertEquals(drugstoreEntity.getEmail(), result.email());
        assertEquals(drugstoreEntity.getPhone(), result.phone());
    }

}