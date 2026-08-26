package com.example.improto;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	private PersonService personServ;
	
	public PersonController(PersonService userServ) {
		this.personServ = userServ;
	}
	
	@RequestMapping("/")
	public String handle() {
		return "Hello World!";
	}
	
	@RequestMapping("/api/")
	public String api() {
		return "API here!";
	}
	
	//GETs
	@GetMapping("/persons/")
	public List<Person> getUser() {
		return personServ.findAll();
	}
	
	@GetMapping("/persons/{id}/")
	public Person getUserById(@PathVariable Integer id) {
		return personServ.findById(id);
	}
	
	//POSTs
	// add a new Person entry
	// 		this will strip the ID out of the input Person entry
	// 		to let the JPA database framework generate a unique ID by itself 
	@PostMapping("/")
	public ResponseEntity<Person> add(@RequestBody Person person) {
		return personServ.postReqRaw(person);
	}
	
	// update a Person entry by a specific id
	// 	note: you *cannot* add a new entry with this! 
	@PostMapping("persons/{id}/")
	public ResponseEntity<Person> update(@PathVariable Integer id, @RequestBody Person person) {
		Optional<Integer> inId = Optional.ofNullable(id);
		//check path ID is not null
		if (inId.isPresent()) {
			//check if an entry by that id is not in the database
			if (personServ.findById(id) == null) {
				//entry is not in data base, therefore throw an error
				throw new InvalidInputException("The ID supplied in the path is null.");
			} else {
				return personServ.postReqWithId(id, person);
			}
		} else {
			//supplied ID in the path is null, therefore throw an error
			throw new NotFoundException("Supplied ID does not exist. ID is null.");
		}
	}
}
