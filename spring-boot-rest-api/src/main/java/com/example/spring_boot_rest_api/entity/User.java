package com.example.spring_boot_rest_api.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity //Class veritabanında bir tabloya karşılık gelecektir.
@Table(name = "KULLANICILAR") //Tablo ismini KULLANICILAR şeklinde değiştirdik.
/*
Getter-Setter anostasyonlarını ayrı ayrı ekleyebiliriz
@Getter
@Setter
*/
@Data //Toplu şekilde Getter-Setter metotları ekleyebiliriz

//BaseEntity'yi extends ettik ve User class'ı Serializable özelliğini kazanmış oldu.
public class User extends BaseEntity { //Tablo ismi default olarak class ismi olur. Sütun isimleri aşağıda tanımlanan fieldların adları olur.

    @Id //Tabloda id alanının primary key olduğunu belirtir.
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_gen", initialValue = 100, allocationSize = 1) //SEQUENCE'ın özelliklerini değiştirmek için yararlandığımız anotasyon
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen") //Primary key değerinin artım stratejisini belirlemek için, en performanslı strateji SEQUENCE
    @Column(name = "ID") //Mevcut sütun özelliğini değiştirmek için
    private Long id; //primary key

    @Column(name = "ISIM", length = 100)
    private String firstName;

    @Column(name = "SOYISIM", length = 100)
    private String lastName;
}

/*
Bu kod bloğu, User adında bir sınıfı bir JPA varlığı (entity) olarak tanımlar. Bu sınıf, veritabanındaki "KULLANICILAR" adlı
tabloya karşılık gelir. id alanı birincil anahtar olarak tanımlanmış ve SEQUENCE stratejisi ile otomatik olarak artan bir değer
alacak şekilde yapılandırılmıştır. firstName ve lastName alanları, sırasıyla "ISIM" ve "SOYISIM" adlı sütunları temsil eder.
*/