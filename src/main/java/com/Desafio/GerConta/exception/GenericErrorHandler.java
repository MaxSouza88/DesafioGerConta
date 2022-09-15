package com.Desafio.GerConta.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericErrorHandler {
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<MensagemErro> illegalArgumentExceptionHandler(IllegalArgumentException e) {
        return new ResponseEntity<>(new MensagemErro(HttpStatus.BAD_REQUEST.toString(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MensagemErro{

        private String mensagemDoUsuario;
        private String mensagemDoDeveloper;

    }
}
