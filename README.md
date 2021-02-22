# Bakery management app

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
- Open the project with an IDE and build the project. If you want to use command line, run `gradle install` to install
  dependencies than `gradle build` to build the project.

# React application

- It has not been added yet.

# TODO

- Improve README file
- Complete repositories
- Add buniness layer
- Complete graphql data fetchers
- Update schema file
- Add react application.
- Add unit tests