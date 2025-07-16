package br.com.fiap.FarmaNear_Register.infra.springController;

import br.com.fiap.FarmaNear_Register.controller.GetDrugstoreController;
import br.com.fiap.FarmaNear_Register.controller.dto.AddressDto;
import br.com.fiap.FarmaNear_Register.controller.dto.DrugstoreDto;
import br.com.fiap.FarmaNear_Register.controller.dto.InsertDrugstoreDto;
import br.com.fiap.FarmaNear_Register.infra.gateway.DrugstoreJpaRepository;
import br.com.fiap.FarmaNear_Register.usecases.CreateDrugstoreUseCase;
import br.com.fiap.FarmaNear_Register.utils.JsonFormatUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegisterControllerTest {

    @Mock
    private CreateDrugstoreUseCase createDrugstoreUseCase;

    @Mock
    private RegisterController registerController;

    @Mock
    private GetDrugstoreController getDrugstoreController;

    private MockMvc mockMvc;
    private AutoCloseable mock;

    @BeforeEach
    public void setup() {
        mock = MockitoAnnotations.openMocks(this);
        registerController = new RegisterController(createDrugstoreUseCase, getDrugstoreController);

        mockMvc = MockMvcBuilders
                .standaloneSetup(registerController)
                .build();
    }

    @AfterEach
    public void close() throws Exception {
        mock.close();
    }

    @Test
    public void createDrugstore() throws Exception {
        AddressDto addressDto = new AddressDto("Rua Jose Bonifacio", "150", "Apto 201", "Rio de Janeiro",
                "Rio de Janeiro", "24440874");

        InsertDrugstoreDto insertDrugstoreDto = new InsertDrugstoreDto("70105796000122", "Farm express", "farm.express@hotmail.com",
                "21 99988776655", addressDto);

        DrugstoreDto drugstoreDto = new DrugstoreDto("70105796000122", "Farm express", "farm.express@hotmail.com",
                "21 99988776655");

        when(createDrugstoreUseCase.createDrugstore(insertDrugstoreDto)).thenReturn(drugstoreDto);

        mockMvc.perform(post("/register/drugstore")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonFormatUtil.asJsonString(insertDrugstoreDto))
        ).andExpect(status().isOk());

        verify(createDrugstoreUseCase, times(1)).createDrugstore(insertDrugstoreDto);
    }

}