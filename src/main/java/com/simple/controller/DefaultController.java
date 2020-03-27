package com.simple.controller;

import com.simple.exceptions.InvalidArgumentsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class DefaultController extends ResponseEntityExceptionHandler {

    private static final Object GENERIC_ERROR_CODE = "CAL-0001";

    @ExceptionHandler(InvalidArgumentsException.class)
    public ResponseEntity<Object> handleInvalidArgumentsException(InvalidArgumentsException exce) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("code", InvalidArgumentsException.ERROR_CODE);
        body.put("message", InvalidArgumentsException.MESSAGE);
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", GENERIC_ERROR_CODE);
        map.put("message", ex.getCause() != null ? ex.getCause() : "Invalid request body");
        map.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
