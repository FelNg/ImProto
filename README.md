# ImProto - Back End
A prototype created to learn how to create various back-end-related systems using Java and other technologies.
The back-end counterpart for ImProto, which can be found at:
[GitHub](https://github.com/FelNg/ImProto-Front) | [Codeberg](https://codeberg.org/telios/ImProto-Front)

---

## Technologies 
**Implemented so far:**
- Java, Spring, Spring Boot, RESTful API (GET and POST), JPA, and JUnit.

**Planned to be implemented:**
- H2.

---

## Functionality
**Implemented so far:**
- A Spring Boot application following the Controller-Service-Repository-Database architecture.
- So far, a basic Person object is holding a collection of data, organized in a Repository layer. All the data input-output processing is handled by the Service layer.
- The Controller layer has a rudimentary implementation of a RESTful API, enabling data reads with GET requests and data input with POST requests.
- Testing via Junit Tests.

**To be implemented:**
- Potentially change data entry updates to PATCH requests instead?
- Persistent H2 database.
  - Potentially move to PostgreSQL later.
- Functional front end 