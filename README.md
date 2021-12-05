# userServer
Потрібно зробити сервер на наступних технологіях: Java 8, Spring Boot, Spring Data, Apache Maven. 
БД in-memory, скажімо H2. В базі даних зв'язок один до багатьох між User та Article. 
User має такі поля: id, name, age. Article має такі поля: id, text, color (enum). 
На старті аплікації в БД повинно добавлятися 5-10 випадкових Users з Articles. 
Потрібно зробити наступний АРІ:
1/ Дістати всіх Users, в яких age більше за якесь значення
2/ Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а
3/ Дістати унікальні name з Users, в яких більше ніж 3 Articles
4/ Зберегти User
5/ Зберегти Article
6/ Також потрібно зробити наступний тип security: JWT-based
7/ Також потрібно написати 1-2 JUnit тести на будь який з цих методів АРІ

Запросы в файле request.http

H2-console: 
http://localhost:8080/h2-console
Driver Class:	org.h2.Driver
JDBC URL:	jdbc:h2:mem:userBd
User Name: userBase
Password:	
