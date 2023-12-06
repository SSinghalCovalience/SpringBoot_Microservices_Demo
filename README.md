# Microservices Application
This is a microservices application built with Spring Boot. It consists of the following services:

# Config Server
The Config Server provides a centralized configuration for all the microservices. It is implemented using Spring Cloud Config Server.
The Config Server connects to a Git repository that contains the configuration files for each microservice. When a microservice starts up, it contacts the Config Server to get its configuration. This allows configuration to be externalized and centrally managed.

# API Gateway
The API Gateway is the single entry point for all clients. It handles routing, authentication, load balancing, caching, request shaping, and more. It provides a unified API layer that simplifies the client and decouples it from the actual microservices.
The API Gateway is implemented using Spring Cloud Gateway. It provides routing rules to route requests to the appropriate microservice. It also handles cross-cutting concerns like security, monitoring, and resiliency.

# Service Registry
The Service Registry keeps track of all the available microservices. It enables service discovery between microservices using Netflix Eureka.
When a new microservice starts, it registers itself with the Service Registry. Other microservices can look up registered services and make requests to them without hardcoding endpoints and URLs.

# Employee Service
The Employee Service manages employee data including profiles, payroll details, time tracking, etc. It exposes REST APIs for CRUD operations on employee data.
Built using Spring Boot, the Employee Service connects to a database to persist employee records. It registers itself with the Service Registry on startup.

# Department Service
The Department Service deals with department data like members, equipment allocation, budgets, etc. It provides REST APIs for managing department information.
Implemented with Spring Boot, it saves department data to a database. On startup it registers with the Service Registry to be discovered by other services.

The microservices communicate over HTTP using a RESTful API design. Common technologies used across services include Spring Boot, Spring Cloud, Netflix OSS, Docker, and MongoDB/SQL databases.
This covers the major components of the microservices application architecture. Each service is independently deployable and scalable. The Config Server and Service Registry enable centralized configuration and service discovery. The API Gateway handles a unified entry point and cross-cutting features.


# Run Commands 

mvn clean install

# Run Order 
1. Config Server
2. Service Registry
3. API Gateway
4. Employee Service
5. Department Service