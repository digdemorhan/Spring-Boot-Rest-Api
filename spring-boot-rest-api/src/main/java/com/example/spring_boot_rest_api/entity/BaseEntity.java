package com.example.spring_boot_rest_api.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass //Bir sınıfın JPA tarafından yönetilen varlık sınıfları için temel bir sınıf olarak kullanılmasını sağlar.
//BaseEntity class'ını extends eden tüm class'larda bu fieldlar miras olarak alınacaktır.
@Getter
@Setter
@ToString

/*Serializable interface'ini implements ederek nesneyi networkten taşıyabilme yeteneğini elde etmiş oluruz ya da diske yazdırıp
oradan okuyabiliriz.
*/
public class BaseEntity implements Serializable {

    //Bu alanlar tüm tablolarda ortak olacaktır.
    private Date createdDate;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}

/*
Bu kod bloğu, JPA (Java Persistence API) kullanarak bir veritabanı varlığı için temel özellikleri tanımlayan bir sınıfı
temsil eder. BaseEntity sınıfı, veritabanı tablosunda yer almayacak, ancak bu sınıfı miras alan diğer varlık sınıfları için
ortak özellikleri sağlar.
*/

/*
Oluşturulacak tüm tablolarda ortak olması istenilen alanlar vardır. Her tabloda kim kayıt yaptı, ne zaman kayıt yaptı,
güncellenme tarihi ve güncelleyen kişi gibi özellikler vardır ve bunları tek bir sınıftan yönetmek daha kolay olacaktır.
* */

