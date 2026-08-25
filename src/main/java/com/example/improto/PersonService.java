package com.example.improto;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
class PersonService {
	@Autowired
	private PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public Person save(Person person) {
		return personRepo.save(person);
	}
	
	// Return a list of Users through Spring JPA Repository findAll()
	public List<Person> findAll() {
		return personRepo.findAll();
	}
	
	public Person findById(int id) {
		return personRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	public ResponseEntity<Person> postReqRaw(Person person) {
		//strip data out of the RequestBody for input
		Person inPerson = Person.builder()
				.firstName(person.getFirstName())
				.lastName(person.getLastName())
				.age(person.getAge())
				.build();
		
		//save the input Person into the repo & create a new Person to respond with
		Person personResponse = this.save(inPerson);
		
		//return a response
		return ResponseEntity
				.created(URI.create("/persons/" + personResponse.getId() + "/"))
				.body(personResponse);
	}
	
	public ResponseEntity<Person> postReqWithId(Integer id, Person person) {
		//strip data out of the RequestBody for input
		//including ID this time as it is an update to an entry based on ID
		Person personIn = Person.builder()
				.firstName(person.getFirstName())
				.lastName(person.getLastName())
				.age(person.getAge())
				.id(id)
				.build();
		
		//save the input Person into the repo & create a new Person to respond with
		Person personResponse = this.save(personIn);
		
		//return a response
		return ResponseEntity
				.created(URI.create("/persons/" + personResponse.getId() + "/"))
				.body(personResponse);
	}
}
