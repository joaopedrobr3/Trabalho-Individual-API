package org.serratec.Ong.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    


@ExceptionHandler(RecursoRepetidoException.class)
@ResponseStatus(HttpStatus.CONFLICT)
public String RecursoRepetidoDigitado(RecursoRepetidoException ex) {
    return ex.getMessage();
}

@ExceptionHandler(RecursoNaoEncontradoException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public String RecursoNaoEncontradoException(RecursoNaoEncontradoException ex) {
    return ex.getMessage();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {
    Map<String, String> erros = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
        .forEach(erro -> erros.put(erro.getField(), erro.getDefaultMessage()));
    return erros;
}
}
