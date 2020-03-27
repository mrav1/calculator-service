package com.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.dto.ResponseDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @WithMockUser("USER")
    @Test
    void addTest(@Autowired MockMvc mvc) throws Exception {
        MvcResult result = mvc.perform(post("/api/add").content("{\"x\":120,\"y\":50}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expectedResponse = objectMapper.writeValueAsString(new ResponseDTO("170"));
        Assertions.assertThat(expectedResponse).isEqualToIgnoringWhitespace(actualResponse);
    }

    @WithMockUser("USER")
    @Test
    void diffTest(@Autowired MockMvc mvc) throws Exception {
        MvcResult result = mvc.perform(post("/api/diff").content("{\"x\":120,\"y\":50}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expectedResponse = objectMapper.writeValueAsString(new ResponseDTO("70"));
        Assertions.assertThat(expectedResponse).isEqualToIgnoringWhitespace(actualResponse);
    }

    @WithMockUser("USER")
    @Test
    void invalidArgsTest(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(post("/api/diff").content("{\"x1\":\"120\",\"y1\":\"50\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}
