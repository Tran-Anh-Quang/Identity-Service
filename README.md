# Learn-Springboot

## Description
Learn-Springboot is a project aimed at exploring Spring Boot framework functionalities. This project utilizes various dependencies to enable the development of RESTful web services with data persistence, validation, security, and testing capabilities.

## Dependencies
- **spring-boot-starter-data-jpa**: Provides support for Java Persistence API (JPA) including Hibernate implementation.
- **spring-boot-starter-web**: Starter for building web, including RESTful, applications using Spring MVC.
- **spring-boot-starter-validation**: Starter for using Java Bean Validation with Hibernate Validator.
- **mapstruct**: An annotation processor for generating bean mappings.
- **spring-security-crypto**: Spring Security cryptographic library.
- **nimbus-jose-jwt**: A library for parsing, generating, and validating JWT (JSON Web Tokens).
- **spring-boot-starter-test**: Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest, and Mockito.
- **spring-security-test**: Spring Security testing utilities.
- **spring-boot-starter-oauth2-resource-server**: Starter for OAuth 2.0 resource server.
- **jackson-datatype-jsr310**: Module to support Java 8 Date & Time API in Jackson (JSON processor).
- **h2**: Embedded in-memory database for testing purposes.
- **spotless-maven-plugin**: Maven plugin for code formatting.
- **spring-boot-starter-mail**: Starter for using Spring Framework's Email sending support.
- **junit-jupiter**: JUnit 5 integration for Testcontainers.
- **postgresql**: PostgreSQL JDBC driver.
- **lombok**: Annotation processor library to reduce boilerplate code.

## Maven Plugins
- **spring-boot-maven-plugin**: Plugin for packaging Spring Boot applications.
- **jacoco-maven-plugin**: Plugin for code coverage reports generation.
- **spotless-maven-plugin**: Plugin for enforcing code formatting rules.
- **maven-compiler-plugin**: Plugin for compiling Java sources.

## Build Configuration
- Java version: 17
- Code formatting rules are enforced using Spotless.
- Code coverage reports are generated using JaCoCo.
- Annotation processors are configured for Lombok and MapStruct.

## Note
This project is configured with Testcontainers for integration testing with PostgreSQL, and H2 database for unit testing purposes.

