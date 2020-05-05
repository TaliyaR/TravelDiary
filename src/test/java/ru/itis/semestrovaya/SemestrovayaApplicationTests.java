package ru.itis.semestrovaya;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.itis.semestrovaya.controllers.SignUpController;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@WebMvcTest(controllers = SignUpController.class)
class SemestrovayaApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Передача объекта без поля name возвращает код 400")
    void addTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"email\":\"user@server.com\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }


}
