package br.edu.ifpb.projeto.utils;

import br.edu.ifpb.projeto.exceptions.EventNotFoundException;
import br.edu.ifpb.projeto.exceptions.OrganizerNotFoundException;
import br.edu.ifpb.projeto.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionConverter {

    @ExceptionHandler(EventNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String converter(EventNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String converter(PersonNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(OrganizerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String converter(OrganizerNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String converter(MethodArgumentTypeMismatchException e){
        return e.getMessage();
    }
}
