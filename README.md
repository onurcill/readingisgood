
# Reading Is Good

ReadingIsGood is an online books retail firm which operates only on the Internet. Main
target of ReadingIsGood is to deliver books from its one centralized warehouse to their
customers within the same day. That is why stock **consistency** is the first priority for their
vision operations.

## Tech Stack

* Java 11
* Spring Boot 2.5.0
* Maven
* Docker
* H2 database
* JUnit
* Mapstruct
* JWT
* Swagger

## Project Structure & Design
**MULTI-MODULE MAVEN PROJECT** 


![image](https://i.ibb.co/LRqGrgB/structure.png)

- **App Module :** It contains the basic to run the Spring Boot Application. It uses only reading-is-good-rest module.
- **Bom Module :** It contains dependencies and manages dependencies
- **Parent Module :** It defines reading-is-good-bom module manage dependencies
- **Data Module :** It contains all the data repositories and access logic
- **Rest Module :** The REST interface and implementation. It also contains mappers.It uses the business logic included in reading-is-good-service module.
- **Service Module :** It contains business logic. It contains DTO's and mappers. It use the reading-is-good-data module to access data.
- **Grpc Module :** According to my design, this module can be added easily in the future. Using the same business, we can provide grpc endpoints with rest.

## GIT Flow
Can be thought of as a short-term project. Although it is a short-term study, we must continue to apply some principles.Finished my work on feature, develop and master branches.

![image](https://i.ibb.co/V9T3xMt/gittt.png)

Follow the link to see more details of my commits. [Github][1]

## API Reference & Swagger

#### Authorize with JWT token

```http
  POST /api/v1/authorization
```
| Parameter | Type     | Definition                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `string` | **Must**. Authorize email to get token  |
| `password`      | `string` | Authorize psw to get token |



![](https://s6.gifyu.com/images/Medya2.gif)


#### Create Book

```http
  POST /api/v1/books
```

#### Update Book

```http
  PATCH /api/v1/books/{id}
```

#### CreateCustomer

```http
  POST /api/v1/customers
```

#### Get Orders of Customer

```http
  GET /api/v1/customers/{id}
```

#### Process Order
```http
  POST /api/v1/orders
```

#### Get Order By ıd
```http
  GET /api/v1/orders/{id}
```

#### Get Orders By Date Interval
```http
  GET /api/v1/orders
```

#### Get Customer Monthly Statistics
```http
  GET /api/v1/statistics/{id}
```

# Build & Run

This is a step-by-step guide how to build and run the project using Docker.

- First you need to install dependencies by running clean and install maven commands.
- Then to build and run the project on docker, you need to run following commands:
    - docker build -f Dockerfile -t readingisgood-docker .
    - docker images (to see if image is build)
    - docker run -p 8080:8080 readingisgood-docker
- Once you run the server you can access the project at port 8080.
- You can see API documentation http://localhost:8080/swagger-ui.html
- To access endpoints you need the first call <b>/api/v1/authorization</b> request. This will generate jwt token and set value to the request header with **JWT** key.
- Then you can call other APIs.


## Postman

Postman Collection is being shared within the project.

[1]: https://github.com/onurcill/readingisgood
  