package com.training.mongospring.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.training.mongospring.services.exception.ObjectNotFoundException;

@ControllerAdvice   //indica que essa classe é responsável por tratar exceções
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)    //anotação para identificar o tratamento
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
