package br.com.letscode.postosaude.testesUnitariosController;

import br.com.letscode.postosaude.model.CargosEnum;
import br.com.letscode.postosaude.model.Profissional;
import br.com.letscode.postosaude.repository.ProfissionalRepositorio;
import br.com.letscode.postosaude.controller.ProfissionalController;
import br.com.letscode.postosaude.services.PacienteService;
import br.com.letscode.postosaude.services.ProfissionalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration
@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = ProfissionalController.class)
public class ProfissionalControllerTest {

    @MockBean
    private ProfissionalService profissionalService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Teste consultar todos os Profissionais controller")
    void selecionarTodosControllerTest() throws Exception{
        List<Profissional> profissionalList = new ArrayList<>();
        profissionalList.add(new Profissional("Profissional 1", CargosEnum.PROFISSIONAL_SAUDE, null));
        profissionalList.add(new Profissional("Profissional 2", CargosEnum.PROFISSIONAL_SAUDE, null));

        Mockito.when(profissionalService.selecionarTodos())
                .thenReturn(profissionalList);

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/profissional-rest")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(jsonPath("$", Matchers.hasSize(profissionalList.size())))'
    }

    @Test
    @DisplayName("Teste remover Profissional controller")
    void deleteProfissionalControllerTest() throws Exception{

    }

}