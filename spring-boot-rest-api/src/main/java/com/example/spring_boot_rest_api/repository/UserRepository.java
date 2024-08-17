package com.example.spring_boot_rest_api.repository;


import com.example.spring_boot_rest_api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;

/*@Repository anotasyonunun eklenmesine gerek yok çünkü JpaRepository extends edildiği için Spring bunun bir
repository katmanı olduğunu biliyor
 */

//Interface hangi class'a hizmet ediyorsa onu extends ediyoruz ve primary key tipini belirtiyoruz
public interface UserRepository extends JpaRepository<User, Long> {


    /*
    //Alınan FirstName değerine göre arama yapıp bu kayıt bulunuyorsa User tipine göre dönüş sağlayacak
    User findByFirstName(String firstName);

    //FirstName ve LastName'e göre arama yapalım
    User findByFirstNameAndLastName(String firstName, String lastName);
     */

    /*
    //Alınan parametreye göre sorgu aşağıdaki anotasyon içerisinde yazılarak kayıt döndürülebilir
    @Query("")
    User getUser(String user);
     */
}
