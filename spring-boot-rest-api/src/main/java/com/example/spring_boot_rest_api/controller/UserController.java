package com.example.spring_boot_rest_api.controller;


import com.example.spring_boot_rest_api.dto.UserDto;
import com.example.spring_boot_rest_api.entity.User;
import com.example.spring_boot_rest_api.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
//import java.awt.print.Pageable;
import java.util.List;

@RestController //API olarak dışarıya açılabilmesi için eklenen anotasyon
@RequestMapping("/user") //API'nin hangi adreste yayınlanacağını özelleştirmek için
public class UserController {

    //Controller katmanı Service katmanıyla haberleşecek. Bu yüzden bir property eklememiz lazım
    //@Autowired //UserService'in referansı Controller içindeki property'e enjekte edildi
    //private UserService userService;


    //Bunun yerine daha basit bir yaklaşım da kullanabiliriz: Constructor injection.

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    /*Böylelikle property'e en başta değer atamayı ya da constructor üzerinden atama yapmayı zorunlu kılar.
    Run-time'da çalışırken property'e herhangi bir atama yapılmasının önüne geçilmiş olundu.
    */


    @PostMapping("/create") //Burada tanımlanan URL'e bir POST isteği geldiğinde bizi createUser metoduna yönlendirecek.
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){ //JSON nesnesini User class'larıyla eşleştirmek için bu anotasyonu ekledik.
        UserDto resultUser = userService.createUser(user); //Dönen değer bir user nesnesinde tutuldu
        return ResponseEntity.ok(resultUser); //ResponseEntity'nin ok metodunda oluşturulan kayıt döndürüldü
    }
    //Metodun dönüş tipini ResponseEntity içerisinde döndürmek, metotlara ortak imza yeteneği kazandırır.


    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUsers (){ //Generic type'ını <List<User>> olarak aldık
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users); //ok metodu static-builder bir metottur
    }

    //User id'si üzerinden bir sorgulama işlemi gerçekleştirelim
    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
        UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user){ //id ile kaydın varlığı kontrol edilecek, varsa user nesnesiyle güncelleyeceğiz
        UserDto resultUser = userService.updateUser(id, user);
        return ResponseEntity.ok(resultUser);
    }


    //Server Side Pagination 1
    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> pagination(@RequestParam int currentPage, @RequestParam int pageSize){ //Hangi sayfayı getirecek (currentPage) ve o sayfada kaç kayıt olacak (pageSize)
        return ResponseEntity.ok(userService.pagination(currentPage, pageSize));
    }

    /*
    Server Side Pagination 1 daha manuel bir yaklaşımdır ve sadece sayfa numarası ve sayfa boyutu gibi temel parametrelerle
    çalışır.
     */

    //Server Side Pagination 2
    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<User>> pagination(Pageable pageable){
        return ResponseEntity.ok(userService.pagination(pageable));
    }

    /*
    Server Side Pagination 2 daha esnek ve genişletilebilir bir yapı sunar, çünkü Pageable nesnesi sıralama gibi
    ek bilgileri de içerir. Bu yaklaşım, genellikle daha fazla kontrol ve esneklik gerektiğinde tercih edilir.
     */

    //Server Side Pagination 3
    @GetMapping("/pagination/v2")
    public ResponseEntity<Slice<User>> slice(Pageable pageable){ //Responce type'ını Page yerine SLice aldık
        return ResponseEntity.ok(userService.slice(pageable));
    }

    /*
    Page ile Slice'ın farkı, Page toplam eleman sayısını bulmak için ekstradan count sorgusu çalıştırır. Slice ise
    istenilen kayıt sayısının bir fazlasını aratarak başka kayıt olup olmadığını anlar. Page'den daha performanslıdır.
    Page: Tam teşekküllü bir pagination çözümüdür, toplam sayfa sayısı, eleman sayısı gibi meta veriler içerir. Pagination
    bileşenleri gibi durumlar için idealdir.
    Slice: Daha hafif ve hızlı bir çözüm sunar. Daha az veri ve sadece "bir sonraki sayfa var mı?" sorusuna odaklanır.
    Performansın önemli olduğu ve ayrıntılı pagination bilgilerine ihtiyaç duymadığınız durumlarda kullanılır.
     */


    @DeleteMapping("/remove/{id}") //PathVariable ismi id'den farklı olabilir, başka bir şey de yazabiliriz, ancak metottaki path ile aynı isimde olmalıdır
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){ //Boolean değer dönecek, doğru şekilde silindiyse true, silinmediyse false
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }

}

















