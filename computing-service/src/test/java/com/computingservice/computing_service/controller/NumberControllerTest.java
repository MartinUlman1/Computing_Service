package com.computingservice.computing_service.controller;

import com.computingservice.computing_service.service.NumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class NumberControllerTest {

    @MockBean
    private NumberService numberService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new NumberController(numberService)).build();
    }

    @Test
    void testCalculate() throws Exception {
        // Simulace chování služby pro číslo 789
        when(numberService.processNumber(789)).thenReturn(809L);

        // Test pro GET /api/calculate/{number}
        mockMvc.perform(get("/api/calculate/789"))
                .andExpect(status().isOk())
                .andExpect(content().string("809"));
    }

    @Test
    void testCalculateEdgeCase() throws Exception {
        // Test pro GET /api/calculate/{number} pro jiné číslo
        when(numberService.processNumber(7892184)).thenReturn(32363242L);

        mockMvc.perform(get("/api/calculate/7892184"))
                .andExpect(status().isOk())
                .andExpect(content().string("32363242"));
    }

    @Test
    void testCalculateNoNumber() throws Exception {
        // Test pro GET /api/calculate/{number} pro neexistující číslo (nebo neplatné)
        mockMvc.perform(get("/api/calculate/abc"))
                .andExpect(status().isBadRequest());
    }
}
