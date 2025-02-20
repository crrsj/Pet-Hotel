package br.com.pet.infra;

import br.com.pet.dto.ErrorMessage;
import br.com.pet.dto.ValidateFields;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorMessage>objectNotFound(){
        var error = new ErrorMessage(HttpStatus.BAD_REQUEST,"Object not found !");
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validatingFields(MethodArgumentNotValidException ex){
      var errors = ex.getFieldErrors();
      return ResponseEntity.badRequest().body(errors.stream().map(ValidateFields::new).toList());
    }

}
