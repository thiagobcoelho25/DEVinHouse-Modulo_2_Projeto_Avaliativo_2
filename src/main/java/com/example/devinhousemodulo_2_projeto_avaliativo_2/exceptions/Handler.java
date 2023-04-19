package com.example.devinhousemodulo_2_projeto_avaliativo_2.exceptions;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class Handler {

    // OLHAR : https://salithachathuranga94.medium.com/validation-and-exception-handling-in-spring-boot-51597b580ffd
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult().getFieldErrors()
//                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
//    }
//
//    private Map<String, List<String>> getErrorsMap(List<String> errors) {
//        Map<String, List<String>> errorResponse = new HashMap<>();
//        errorResponse.put("errors", errors);
//        return errorResponse;
//    }

    //  MUITO BOM ARTIGO - https://reflectoring.io/bean-validation-with-spring-boot/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request ) {

        ValidationErrorResponse error = new ValidationErrorResponse();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.getCampos().add(
                    new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());
        error.setPath(request.getRequestURI());
        error.setError("Erros de Validação");

        return error;
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<StandardError> businessRule(DateTimeParseException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(), "Error de Transformação de formato de Data","Transformação de Formato de Data Não Suportada");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err); // OU INTERNAL_SERVER_ERROR
    }

    // https://www.toptal.com/java/spring-boot-rest-api-error-handling
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        String error = "Malformed JSON request";
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(), error, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<StandardError> businessRule(BusinessRuleException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(),request.getRequestURI(),
                "Regra de negócio nao respeitada", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),request.getRequestURI(),
                "Falha De Busca de Entidade", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }


}
