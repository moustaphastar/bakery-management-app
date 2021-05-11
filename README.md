# Bakery management app

A bakery store management web application, built with spring-boot, graphql-java and
react. The project is not completed yet. Please feel free to submit any issue or any idea you have.

### Requirements

- JDK 1.8 
- Node.js
- Microsoft Sql Server
- Gradle

### Installing Microsoft JDBC Driver

- Download preferred JDBC driver
  from [Microsoft's official download page](https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15)
  .
- Configure the classpath and connection string according to
  this [MSDN page](https://docs.microsoft.com/en-us/sql/connect/jdbc/building-the-connection-url?view=sql-server-ver15).

### Installing & Running

- Clone the project `git clone https://github.com/moustaphastar/bakery-management-app.git` or download the code.
- Open the project with an IDE and build the project. A run/debug configuration might be needed by the IDE, than set up
  the configuration by following the IDE documentation. If want to use command line, execute `gradle build`
  or `gradlew build` to build the project. That might take a long time for the first run. To start and run the
  application execute `gradle bootRun` or `gradlew bootRun`.

### OpenAPI and the swagger ui

- When started in development environment, the application opens the default browser
  and navigates to default swagger ui which is `localhost:8080/swagger-ui.html`. 
  In a production environment, just append `swagger-ui.html` to the url.
  You can the live example [here](https://ehesap.herokuapp.com/swagger-ui.html).
  

- Sample request with swagger ui to fetch country data from the database:
  ```json
  {"query":"{countries{id iso2 iso3 name}}"}
  ```
  Sample response;
  
  ````json5
  {
    "data": {
      "countries": [
        // Omitted for brevity
        {
          "id": 21,
          "iso2": "BY",
          "iso3": "BLR",
          "name": "Belarus"
        },
        {
          "id": 22,
          "iso2": "BE",
          "iso3": "BEL",
          "name": "Belgium"
        }
        // Omitted for brevity
      ]
    }
  }
  ````

- Alternatively, GraphQL Playground or Postman applications can be used:
  ![Sample request with Postman](https://github.com/moustaphastar/bakery-management-app/blob/postgresqlport/images/sample_req_with_postman.png)   ![Sample request with Postman](https://github.com/moustaphastar/bakery-management-app/blob/postgresqlport/images/graphql_playground_sample.png)


### React application

- It has not been added yet. I will add it soon.

### TODO

- Improve README file
- Implement missing repositories
- Implement business logic
- Implement missing data fetchers for graphql
- Update graphql schema file
- Integrate a payment API
- Add react application.
- Add unit tests