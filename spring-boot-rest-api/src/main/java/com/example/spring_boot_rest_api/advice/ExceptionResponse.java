package com.example.spring_boot_rest_api.advice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Custom Exception Response yapısı

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private LocalDateTime timeStamp;
    private String mesasge;
    private String code;
}
