package com.simple.service;

import com.simple.dto.RequestDTO;
import com.simple.dto.ResponseDTO;
import com.simple.exceptions.InvalidArgumentsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

import static com.simple.utils.NumberUtil.isNumeric;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    @Override
    public ResponseDTO add(RequestDTO request) throws InvalidArgumentsException {
        validateRequest(request);
        BigDecimal value = new BigDecimal(request.getX()).add(new BigDecimal(request.getY()));
        return new ResponseDTO(value.toString());
    }

    @Override
    public ResponseDTO substract(RequestDTO request) throws InvalidArgumentsException {
        validateRequest(request);
        BigDecimal value = new BigDecimal(request.getX()).subtract(new BigDecimal(request.getY()));
        return new ResponseDTO(value.toString());
    }

    private void validateRequest(RequestDTO request) throws InvalidArgumentsException {
        if (request == null || !isNumeric(request.getX()) || !isNumeric(request.getX())) {
            LOG.error("Received invalid arguemnts: {}", request);
            throw new InvalidArgumentsException();
        }
    }

}
