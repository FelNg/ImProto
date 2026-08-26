package com.example.improto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ImprotoApplicationTests {
	//test service mock initialization
	@MockitoBean
	PersonRepository personRepo;
	
	@Autowired
	PersonService personServ;
	
	// test a basic data insertion and assure the data is saved correctly
	@Test
	void testData() {
		//raw insert - let JPA autogenerate id
		Person person1 = Person.builder()
				.firstName("bob")
				.lastName("nolan")
				.age(40)
				.id(0)
				.build();
		
		when(personRepo.save(person1)).thenReturn(person1);
		when(personRepo.findById(0)).thenReturn(Optional.of(person1));
		
		Person saveResult = personServ.save(person1);
		
		//assert that the Service has saved one Person entry
		assertEquals("bob", personServ.findById(0).getFirstName());
		assertEquals("nolan", personServ.findById(0).getLastName());
		assertEquals(40, personServ.findById(0).getAge());
		assertEquals(0, personServ.findById(0).getId());
		
		//make sure that personRepo.findById(0) was called only four times
		verify(personRepo, times(4)).findById(0);
	}
	
	@Test
	void contextLoads() {
	}
}
