package com.Desafio.GerConta.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGerConta extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUser = messageSource.getMessage("mensagem.invalida",null,null);
        String mensagemDesenvolvedor = ex.getCause().toString();

        return handleExceptionInternal(ex,new MensagemErro(mensagemUser,mensagemDesenvolvedor),headers,HttpStatus.BAD_REQUEST,request);

    }


    protected ResponseEntity<Object> handleHttpMessageNotReadable(IllegalArgumentException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUser = messageSource.getMessage("mensagem.invalida",null,null);
        String mensagemDesenvolvedor = ex.getCause().toString();

        return handleExceptionInternal(ex,new MensagemErro(mensagemUser,mensagemDesenvolvedor),headers,HttpStatus.BAD_REQUEST,request);

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
