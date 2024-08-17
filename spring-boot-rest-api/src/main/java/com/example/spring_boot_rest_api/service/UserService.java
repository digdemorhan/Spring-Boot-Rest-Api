package com.example.spring_boot_rest_api.service;


import com.example.spring_boot_rest_api.dto.UserDto;
import com.example.spring_boot_rest_api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;
//import java.awt.print.Pageable;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    List<UserDto> getUsers();

    UserDto getUser(Long id);

    UserDto updateUser(Long id, UserDto user);

    Boolean deleteUser(Long id);

    Page<User> pagination(int currentPage, int pageSize); //Server Side Pagination 1

    Page<User> pagination(Pageable pageable); //Server Side Pagination 2

    Slice<User> slice(Pageable pageable); //Server Side Pagination 3


}















