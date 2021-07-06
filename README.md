# Opera-app

OperaApp is an application to manage tickets bought on the occasion of an opera session by a user.
There are two roles in the application - ADMIN, USER.
USER can register, log in, select performances and add tickets to his shopping card.
ADMIN has access to create performances, stages, manage performance sessions.

### UML diagram that describes the relationship between the entities.
![oppera](https://user-images.githubusercontent.com/55792704/124586055-a9ae5a00-de5e-11eb-85e5-66570a4a4dc7.png)

###### ADMIN can
- POST,"/stages" - create stage
- GET,"/stages" - review stages
- POST,"/performances" - crete performance
- GET,"/performances" - review performances
- POST,"/performance-sessions" - crete performance session
- ET,"/performance-sessions/available" - get info about available performance-sessions
- PUT,"/performance-sessions/{id}" - chanche
- DELETE,"/performance-sessions/{id}" - delete
- GET,"/users/by-email" - review info about user


###### USER can
- GET,"/stages" - review stages
- GET,"/performances" - review performances
- GET,"/performance-sessions/available" - get info about available performance-sessions
- GET,"/orders" - view his own orders
- POST,"/orders/complete" - create order
- POST,"/shopping-carts/performance-sessions" - add performance-session to shopping cart
- GET,"/shopping-carts/by-user" - review info about user

### Key tools
+ Hibernate, Spring Core, Spring Web, Spring Security
+ MySQL
+ Maven, Tomcat, JSON

### Installation
+ To run the project on your local machine, clone this project into your local folder and open the project in an IDE.

+ Configure Tomcat Server and set up the MySQL DS and MySQL Workbench on your machine.

+ Insert your own MySQL username and login in file db.properties.

+ Setup url: jdbc:mysql://"your host name":"your port"/"your name db"?useUnicode=true&serverTimezone=UTC