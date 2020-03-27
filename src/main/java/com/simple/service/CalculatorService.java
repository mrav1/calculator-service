package com.simple.service;

import com.simple.dto.RequestDTO;
import com.simple.dto.ResponseDTO;
import com.simple.exceptions.InvalidArgumentsException;

public interface CalculatorService {

    ResponseDTO add(RequestDTO request) throws InvalidArgumentsException;

    ResponseDTO substract(RequestDTO request) throws InvalidArgumentsException;

}

