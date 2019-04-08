# Springboot Oauth2 example

(Text on this project is mostly in spanish)

Ejemplo basado en la documentacion de [esta pagina](https://docs.spring.io/spring-security-oauth2-boot/docs/current-SNAPSHOT/reference/htmlsingle/#oauth2-boot-authorization-server-authorization-code-grant)
con un setup inicial a mano (no incluido en la pagina).
Sprig boot esta en estado de transicion respecto a Oauth como lo refleja [esta pagina](https://github.com/spring-projects/spring-security/wiki/OAuth-2.0-Features-Matrix)
`The plan is to also provide support for Authorization Server in future releases` por lo que
actualmente sólo nos queda usar la [version port anterior](http://projects.spring.io/spring-security-oauth/) 

#### Pasos seguidos
1. Crear el proyecto con [Spring Initialzr](https://start.spring.io/)
   - Indicar que es proyecto con web, security
2. Agregar [una pagina index](src/main/resources/static/index.html) para mostrar algo en el login
3. Definir credenciales hardcodeadas de usuario en [config de security](src/main/java/info/kfgodel/oauthtest/WebSecurityConfig.java)
4. Agregar dependencias para spring-security-oauth en el [pom](pom.xml)
5. Marcar la aplicacion con el annotation `@EnableAuthorizationServer`
6. Declarar un client custom en [autorization server](src/main/java/info/kfgodel/oauthtest/AuthorizationServerConfig.java) para soportar grant_type: autorization_code
   - Verificar flujo de autorizacion y login con [este link](http://localhost:8080/oauth/authorize?grant_type=authorization_code&response_type=code&client_id=clientId&state=1234) segun [ejemplo de spring](https://docs.spring.io/spring-security-oauth2-boot/docs/current-SNAPSHOT/reference/htmlsingle/#oauth2-boot-testing-authorization-code-flow)
7. Explicitar un authentication manager en [la configuracion del autorization server](src/main/java/info/kfgodel/oauthtest/AuthorizationServerConfig.java) para permitir el grant password.
8. Reemplazar el index por un controller con data del usuario (en formato JSON)


### Verificar autenticacion

Authorization Code
- http://localhost:8080/oauth/authorize?grant_type=authorization_code&response_type=code&client_id=clientId&extraData=1234

Client credentials:
> curl clientId:clientSecret@localhost:8080/oauth/token -dgrant_type=client_credentials -dscope=any

Password
> curl clientId:clientSecret@localhost:8080/oauth/token -dgrant_type=password -dscope=any -dusername=user -dpassword=password