package org.serratec.Ong.exception;

import org.springframework.http.HttpStatus;
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
}
