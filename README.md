# ImProto
An prototype created to learn how to implement functionalities using various technologies.

---

## Technologies 
**Implemented so far:**
- Java, Spring, Spring Boot, RESTful API (GET and POST), and JPA.

**Planned to be implemented:**
- H2, and JUnit.

---

## Functionality
**Implemented so far:**
- A Spring Boot application following the Controller-Service-Repository-Database architecture.
- So far, a basic Person object is holding a collection of data, organized in a Repository layer. All the data input-output processing is handled by the Service layer.
- The Controller layer has a rudimentary implementation of a RESTful API, enabling data reads with GET requests and data input with POST requests.

**To be implemented:**
- Potentially change data entry updates to PATCH requests instead?
- Proper automated testing via Junit Tests.
- Persistent H2 database.
  - Potentially move to PostgreSQL later.
