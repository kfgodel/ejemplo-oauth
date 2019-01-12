# Springboot Oauth2 example

(Text on this project is mostly in spanish)

Ejemplo basado en la documentacion de [esta pagina](https://spring.io/guides/tutorials/spring-boot-oauth2)
con un setup inicial a mano (no incluido en la pagina).

#### Pasos seguidos
1. Crear el proyecto con [Spring Initialzr](https://start.spring.io/)
  - Indicar que es proyecto con web, security
2. Agregar [una pagina index](src/main/resources/static/index.html) para mostrar algo en el login
3. Definir credenciales hardcodeadas de usuario en [config de security](src/main/java/info/kfgodel/oauthtest/WebSecurityConfig.java)
4.    