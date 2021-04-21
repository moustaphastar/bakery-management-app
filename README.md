# Bakery management app

A sample web application to keep track of products, customers, orders etc.
You can also try an online payment integration (api credentials needed).
Server side is built with spring-boot and qraphql-java, frontend is built
with enlight react admin template and database as H2 embedded.

### Requirements
- JDK 1.8
- Gradle 7.0
- Graphql-java 12.0
- H2 1.4.x
- Node.js

### Installing

- Clone the project `git clone https://github.com/moustaphastar/bakery-management-app.git` or download the code.
- For the first time change the `spring.datasource.url` in the application.properties file as
`spring.datasource.url=jdbc:h2:file:./bakery;TRACE_LEVEL_FILE=4;\
  INIT=RUNSCRIPT FROM 'src/main/resources/h2data.sql';`. This will create and seed the H2 database.
  Remove the `RUNSCRIPT FROM 'src/main/resources/h2data.sql';` part from the file after the first run.
- Run `gradlew bootRun` 