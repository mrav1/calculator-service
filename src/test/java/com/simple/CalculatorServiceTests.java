package com.simple;

import com.simple.dto.RequestDTO;
import com.simple.dto.ResponseDTO;
import com.simple.exceptions.InvalidArgumentsException;
import com.simple.service.CalculatorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class CalculatorServiceTests {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void additionTest() throws InvalidArgumentsException {
        RequestDTO requestDTO = new RequestDTO("100","50");
        ResponseDTO response = calculatorService.add(requestDTO);
        Assertions.assertThat(response.getResult().equals("150"));
    }

    @Test
    void substractionTest() throws InvalidArgumentsException {
        RequestDTO requestDTO = new RequestDTO("100","50");
        ResponseDTO response = calculatorService.add(requestDTO);
        Assertions.assertThat(response.getResult().equals("50"));
    }

}
