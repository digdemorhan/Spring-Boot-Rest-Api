package com.example.spring_boot_rest_api.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class) //illegalException fırlatıldığında çalışabilmesi için (hangi hata sınıfında çalışacaksa onu da ekledik)
    public final ResponseEntity<ExceptionResponse> illegalException(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "1000", exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UserNotFound.class) //illegalException fırlatıldığında çalışabilmesi için (hangi hata sınıfında çalışacaksa onu da ekledik)
    public final ResponseEntity<ExceptionResponse> userNotFound(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "2000", exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    //Öngörülemeyen bir hatanın throw edilmesi (yukarıdakilerden biri değilse burası çalışacak)
    @ExceptionHandler(Exception.class) //illegalException fırlatıldığında çalışabilmesi için (hangi hata sınıfında çalışacaksa onu da ekledik)
    public final ResponseEntity<ExceptionResponse> exception(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "5000", exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }
}

/*
    Burada ve ExceptionResponse class'ında yapılan işlemlerde, kendi oluşturduğumuz ve dönmesini istediğimiz parametrelere
    yönelik olarak kendi exception response'umuzu oluşturmuş olduk.
 */
