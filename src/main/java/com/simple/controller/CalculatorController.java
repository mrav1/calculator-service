package com.simple.controller;

import com.simple.dto.RequestDTO;
import com.simple.dto.ResponseDTO;
import com.simple.exceptions.InvalidArgumentsException;
import com.simple.service.CalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Simple calculator service API")
public class CalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "Add two numbers", response = ResponseDTO.class)
    public ResponseDTO add(@ApiParam(value = "Request payload", name = "Request", required = true)
                           @RequestBody RequestDTO requestDTO) throws InvalidArgumentsException {
        LOG.debug("Received add request: {}", requestDTO);
        return calculatorService.add(requestDTO);
    }

    @PostMapping("/diff")
    @ResponseBody
    @ApiOperation(value = "Difference between two numbers", response = ResponseDTO.class)
    public ResponseDTO substract(@ApiParam(value = "Request payload", name = "Request", required = true)
                                 @RequestBody RequestDTO requestDTO) throws InvalidArgumentsException {
        LOG.debug("Received diff request: {}", requestDTO);
        return calculatorService.substract(requestDTO);
    }

}
