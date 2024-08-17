# SPRING BOOT REST API
# PROJENİN ANA TEMASI
Bu projede, bir Spring Boot REST API uygulaması geliştirilmiştir. Proje, kullanıcı yönetimini sağlayan bir servis ve API oluşturur. Kullanıcıların oluşturulması, güncellenmesi, silinmesi ve listelenmesi gibi temel CRUD işlemlerini desteklemektedir. Ayrıca, istekleri doğrulama ve hata yönetimi için kapsamlı bir mekanizma içermektedir. 

# Proje Dosyaları
![p0987u6y](https://github.com/user-attachments/assets/c749c3c8-9dfc-4671-83d5-5214356bafde)

# Proje Sınıfları
`UserController` sınıfı, kullanıcıların oluşturulması, güncellenmesi, silinmesi ve listelenmesi gibi işlemleri yönetir ve bu işlemler için HTTP isteklerini işler. `UserService` sınıfı, iş mantığını içerir ve `UserRepository` ile etkileşimde bulunur, ayrıca kullanıcı verilerini DTO'lara dönüştürmek için `ModelMapper` kullanır. `ApiExceptionHandler` ve `ExceptionResponse` sınıfları, özelleştirilmiş hata mesajları sağlar ve olası istisnaları yönetir. `UserNotFound` istisnası, kullanıcı bulunamadığında özel bir hata fırlatır. Veritabanı yapısını belirlemek için `User` ve `BaseEntity` sınıfları kullanılır; `User` sınıfı kullanıcı verilerini temsil ederken, `BaseEntity` ortak alanları sağlar. `UserRepository` sınıfı, JPA kullanarak veri erişimi sağlar ve çeşitli arama yöntemleri sunar. Pagination işlemleri, verilerin sayfalı olarak alınmasını sağlar ve `Pageable` ve `Slice` yapılarıyla esnek bir şekilde uygulanır.


# Projenin Önemli Noktaları
<ul>
<li>Hata Yönetimi: Özel bir ExceptionResponse sınıfı oluşturularak, hata durumlarında daha anlamlı ve özelleştirilmiş yanıtlar üretilmektedir.
</li>
<li>DTO Kullanımı: Veritabanı ve dış dünya arasında veri transferinde DTO'lar kullanılarak, veri sızıntısı riskleri azaltılmaktadır.</li>
<li>ModelMapper: DTO ve Entity nesneleri arasında otomatik eşleştirme yaparak, kod tekrarını azaltmaktadır.</li>
<li>Spring Data JPA: Veritabanı işlemlerini kolaylaştıran ve soyutlayan bir katman sunmaktadır.</li>
<li>Pagination: Server-side pagination ile büyük veri kümelerinin daha verimli bir şekilde yönetilmesini sağlar.</li>
<li>Lombok: Getter, setter, constructor gibi boilerplate kodları otomatik olarak üreterek geliştirici üretkenliğini artırır.
</li>
</ul>

----
----

# MAIN THEME OF PROJECT
In this project, a Spring Boot REST API application is developed. The project creates a service and API that enables user management. It supports basic CRUD operations such as creating, updating, deleting and listing users. It also includes a comprehensive mechanism for validating requests and error management. 

# Project Classes
The `UserController` class manages operations such as creating, updating, deleting and listing users and processes HTTP requests for these operations. The `UserService` class contains the business logic and interacts with the `UserRepository`, it also uses `ModelMapper` to convert user data into DTOs. The `ApiExceptionHandler` and `ExceptionResponse` classes provide customized error messages and manage possible exceptions. The `UserNotFound` exception throws a custom error when the user cannot be found. The `User` and `BaseEntity` classes are used to specify the database structure; the `User` class represents user data, while `BaseEntity` provides common fields. The `UserRepository` class provides data access using JPA and provides various search methods. Pagination operations allow data to be paginated and are implemented flexibly with the `Pageable` and `Slice` constructs.

# Highlights of the project
<ul>
<li>Error Management: By creating a special ExceptionResponse class, more meaningful and customized responses are generated in error situations.
</li>
<li>DTO Usage: By using DTOs to transfer data between the database and the outside world, data leakage risks are reduced.</li>
<li>ModelMapper: Reduces code repetition by automatically mapping between DTO and Entity objects.</li>
<li>Spring Data JPA: Provides a layer that facilitates and abstracts database operations.</li>
<li>
Pagination: Provides more efficient management of large datasets with server-side pagination.</li>
<li>Lombok: Increases developer productivity by automatically generating boilerplate code such as getters, setters and constructors.
</li>
</ul>










