# Bakery management app
![Build Status](https://github.com/moustaphastar/bakery-management-app/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=main)

This is a simplified version of a bakery store management web application, built with spring-boot, graphql-java and
react. The project is not completed yet. Please feel free to submit any issue or any idea you have.

# Includes

- Microsoft JDBC driver 8.2.2.jre11
- graphql-java 12.0

# Requirements

- JDK 1.8 or higher to run the application
- Node.js to run the react application
- Microsoft Sql Server
- Gradle

# Installing Microsoft JDBC Driver

- Download preferred JDBC driver
  from [Microsoft's official download page](https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15)
  .
- Configure the classpath and connection string according to
  this [MSDN page](https://docs.microsoft.com/en-us/sql/connect/jdbc/building-the-connection-url?view=sql-server-ver15).

# Installing and running

- Clone the project `git clone https://github.com/moustaphastar/bakery-management-app.git` or download the code.
- Open the project with an IDE and build the project. A run/debug configuration might be needed by the IDE, than set up
  the configuration by following the IDE documentation. If want to use command line, execute `gradle build`
  or `gradlew build` to build the project. That might take a long time for the first run. To start and run the
  application execute `gradle bootRun` or `gradlew bootRun`.

# OpenAPI and the swagger ui

- When the application is started, it tries to open the default browser and the default swagger ui as "localhost:
  8080/swagger-ui.html"

- You can try sample graphql queries but be careful to provide valid json payload.

- Alternatively you can use GraphQL Playground or GraphiQl applications

# React application

- It has not been added yet. I will add it soon.

# TODO

- Improve README file
- Complete repositories
- Add buniness layer
- Complete graphql data fetchers
- Update schema file
- Add react application.
- Add unit tests