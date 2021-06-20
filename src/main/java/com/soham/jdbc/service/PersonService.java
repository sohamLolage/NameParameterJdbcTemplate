package com.soham.jdbc.service;

import java.util.List;

import com.soham.jdbc.Entity.Person;

public interface PersonService {
	public Person getPerson(int id);
	public List<Person> getAllPerson();
	public Person createPerson(Person person);
	public Person updatePerson(Person person);
	public void deletePerson(int id);

}
