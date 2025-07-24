package br.com.maxzdosreis.libraryapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends RuntimeException{

    private String campo;

    public InvalidFieldException(String campo, String message){
        super(message);
        this.campo = campo;
    }
}
