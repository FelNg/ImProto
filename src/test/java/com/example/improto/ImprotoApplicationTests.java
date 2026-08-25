package com.example.improto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImprotoApplicationTests {
	/*private PersonRepository personRepo;
	private PersonService personServ;
	
	private Person createAndReturnPerson() {
		Person person = Person.builder()
				.firstName("bob")
				.lastName("dylan")
				.age(30)
				.id(1)
				.build();
		return personRepo.save(person);
	}
	
	private Person buildPerson() {
		Person person = Person.builder()
				.firstName("amy")
				.lastName("rose")
				.age(20)
				.id(2)
				.build();
		return person;
	}

	@Test
	void givenPerson_whenUpdateOrInsertUsingRepositoryExecture_thenUpserted() {
		// initialize references to service for easier readability
		// insert test
		Person newPerson = buildPerson();
		Person existingPersonById =
				personRepo.findById(newPerson.getId()).get();
		assertNull(existingPersonById);
		
		personServ.updateOrInsertUsingRepository(newPerson);
		
		existingPersonById = personRepo.findById(newPerson.getId()).get();
		assertNotNull(existingPersonById);
	}

	private void assertNull(Person inPerson) {
		if (inPerson != null) {
			throw new AssertionError("Person object is not null!");
		}
	}
	
	// not null check
	private void assertNotNull(Person inPerson) {
		if (inPerson == null) {
			throw new AssertionError("Person object is null!");
		}
	}*/
	
	@Test
	void contextLoads() {
	}
}
