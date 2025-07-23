package br.com.maxzdosreis.libraryapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateRegistration extends RuntimeException {

    public DuplicateRegistration(String message) {
        super(message);
    }
}
