package br.com.maxzdosreis.libraryapi.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
