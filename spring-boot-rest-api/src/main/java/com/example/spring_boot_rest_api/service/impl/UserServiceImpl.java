package com.example.spring_boot_rest_api.service.impl;


import com.example.spring_boot_rest_api.advice.UserNotFound;
import com.example.spring_boot_rest_api.dto.UserDto;
import com.example.spring_boot_rest_api.entity.User;
import com.example.spring_boot_rest_api.repository.UserRepository;
import com.example.spring_boot_rest_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
//import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;

@Service //Class'ın Service katmanı olduğunu belirtmek için bu anotasyon eklendi
@RequiredArgsConstructor //Bunu kullanarak otomatik olarak constructor'ı oluşturdu (Lombok'tan faydalandık)

public class UserServiceImpl implements UserService { //Öncelikle UserService isimli interface'i implements edelim

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class); //İlk parametre dönüşecek class, ikinci parametre dönüştürülecek class
        user.setCreatedDate(new Date()); //Oluşturulma zamanını belirtelim
        user.setCreatedBy("Admin"); //Kim tarafından oluşturulduğunu belirtelim
        return modelMapper.map(userRepository.save(user), UserDto.class); //user dönecek ve UserDto nesnesine çevirilecek
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> dtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public UserDto getUser(Long id) {
        //Optional içinde tutularak kaydın var olup olmadığına dair kontrol yaptırıldı
        Optional<User> user =  userRepository.findById(id); //Generic type'ı user olan bir optinal dönüyor, bu da null pointer exception hatasına düşmesini önlüyor
        if(user.isPresent()){ //eğer id'sini verdiğimiz kayıt varsa
            return modelMapper.map(user, UserDto.class); //user'ı döndür
        }
        //return null; //id'sini verdiğimiz kayıt yoksa da null dönecek (yöntem 1)
        //throw new IllegalArgumentException("Kullanici bulunamadi"); //Artık id'sini verdiğimiz kayıt yoksa null yerine bir throw dönsün (yöntem 2)
        //throw new UserNotFound("Kullanici bulunamadi"); //Kendi oluşturduğumuz sınıfı throw edelim (yöntem 3)
        throw new RuntimeException("Kullanici bulunamadi"); //Öngörülemeyen hata oluştuğunda bununla throw edilir (yöntem 4)
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        //getUser metodunda olduğu gibi id'ye göre kaydın olup olmadığı kontrol edildi
        Optional<User> resultUser =  userRepository.findById(id);
        if(resultUser.isPresent()){ //id'si gelen kayıt varsa
            resultUser.get().setFirstName(user.getFirstName()); //parametre olarak gelen nesneyle güncelledi, firstName'i user'ın firstName'ine atadı
            resultUser.get().setLastName(user.getLastName()); //parametre olarak gelen nesneyle güncelledi, lastName'i user'ın lastName'ine atadı
            resultUser.get().setUpdatedAt(new Date()); //güncellenme tarihi
            resultUser.get().setUpdatedBy("Admin"); //güncelleyen kişi
            return modelMapper.map(userRepository.save(resultUser.get()), UserDto.class); //userRepository'deki save metoduna nesne gönderildi
        }
        return null; //Aranan id'deki kayıt yoksa null döndürecek
    }

    @Override
    public Boolean deleteUser(Long id) {
        //getUser ve updateUser metodunda olduğu gibi id'ye göre kaydın olup olmadığı kontrol edildi
        Optional<User> resultUser =  userRepository.findById(id);
        if(resultUser.isPresent()){ //id'si gelen kayıt varsa
            userRepository.deleteById(id); //userRepository'nin deleteById metoduna istek yapıldı
            return true; //silme başarılı bir şekilde gerçekleştiyse true dönecek
        }
        return false; //silme işlemi gerçekleşmediyse false dönecek
    }


    //Server Side Pagination 1
    @Override
    public Page<User> pagination(int currentPage, int pageSize){
        PageRequest pageable = PageRequest.of(currentPage, pageSize);
        return userRepository.findAll(pageable);
    }

    //Server Side Pagination 2
    @Override
    public Page<User> pagination(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    //Server Side Pagination 3
    @Override
    public Slice<User> slice(Pageable pageable){

        return userRepository.findAll(pageable);
    }



    /*
    UserController'da olduğu gibi yine bu şekilde constructor oluşturabiliriz.

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
     */
}
