package com.soham.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soham.jdbc.Entity.Person;

import com.soham.jdbc.service.PersonService;
@RestController
public class MyControoler {
	@Autowired
	PersonService personService;
	@PostMapping("/person")
	public ResponseEntity<Void> createEmployee(@RequestBody Person person)
	{
		personService.createPerson(person);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPerson()
	{
		List<Person> allPerson = personService.getAllPerson();
		return new ResponseEntity<List<Person>>(allPerson,HttpStatus.OK);
	}
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable int id)
	{
		Person person= personService.getPerson(id);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Integer id)
	{
		personService.deletePerson(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/person")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person)
	{
		Person updatePerson = personService.updatePerson(person);
		return new ResponseEntity<Person>(updatePerson,HttpStatus.OK);
	}
	

}
