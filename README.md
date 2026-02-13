# core-banking-system (cbs)

## [1] About :

cbs is an an evolving platform aimed to manage various banking operations such as account management, transaction processing, and customer relationship management. The system is built using a modular architecture to ensure scalability and maintainability. It incorporates best practices in software development and follows industry standards for security and performance.

## [2] Project Requirement :

- Java 17 or higher
- Kotlin 1.5 or higher
- Spring Boot 2.5 or higher
- Maven 3.6 or higher

## [3] Project Structure :

cbs is a modular/ multi-module project structured as follows:

core-banking-system  
├── api  
├── common  
├── domain  
├── service

## [3.1] domain (module) :

The domain module is the heart of cbs, responsible for defining the core business logic and domain entities of the banking system. It includes classes and interfaces that represent the various components of the banking domain, such as accounts, transactions, customers, and other related entities serving as the foundation for the entire application, providing a clear separation of concerns and ensuring that the business logic is encapsulated within a dedicated layer. This allows for better maintainability and scalability of the system as it evolves over time.

### Liquibase :

**File Naming Convention**

All Liquibase changesets must follow the naming convention below to maintain consistency and avoid conflicts.

**Format**

YYYYMMDD*{DEVELOPER}*{SQL*TYPE}*{SEQUENCE}

**Details**

- **YYYYMMDD** – Date when the changeset is created
- **DEVELOPER** – Developer name or identifier (use uppercase)
- **SQL_TYPE** – Type of change (`DDL` or `DML`)
- **SEQUENCE** – Two-digit sequence number, unique per developer per day

**Examples**

    20200225_JOHN_DDL_01
    20200225_JOHN_DML_02

**Rules**

- Sequence must be unique for the same developer on the same date
- Use `DDL` for schema changes and `DML` for data changes
- This convention must be followed for all Liquibase changesets

## [3.2] service (module):

The service module is the brain of cbs, responsible for implementing the business logic and application services of the core banking system. It acts as an intermediary between the domain layer and the API layer, orchestrating the flow of data and ensuring that the business rules are applied correctly. The service module contains classes that handle various operations such as account management, transaction processing, customer relationship management, and other banking-related functionalities. By encapsulating the business logic within this module, we can maintain a clear separation of concerns and promote a clean architecture for the application.

## [3.3] api (module):

The api module serves as the entry point for external clients to interact with the core banking system. It exposes RESTful endpoints that allow clients to perform various operations such as creating accounts, processing transactions, and managing customer information. The api module is responsible for handling HTTP requests, validating input data, and returning appropriate responses. It acts as a bridge between the external world and the internal workings of the application, ensuring that the business logic implemented in the service module is accessible to clients in a secure and efficient manner.

## [3.4] common (module):

The common module is a shared library that contains utility classes, constants, and common functionalities that are used across multiple modules in the core banking system. It serves as a central repository for reusable code and helps to avoid duplication of logic across different parts of the application.

## Developers

<img src=".\common\src\main\resources\asssets\img\uglyeagle2.0.png" 
     width="20%" alt="uglyeagle" 
     style="float:right; pointer-events: none;"/>
