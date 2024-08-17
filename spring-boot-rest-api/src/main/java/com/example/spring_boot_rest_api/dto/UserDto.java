package com.example.spring_boot_rest_api.dto;


import lombok.Data;

@Data //Get-set metotları için
public class UserDto {

    //Client'a dönecek alanlar belirlendi
    private Long id;
    private String firstName;
    private String lastName;
}
