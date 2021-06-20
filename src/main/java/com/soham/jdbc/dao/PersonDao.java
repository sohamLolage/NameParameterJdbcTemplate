package com.soham.jdbc.dao;

import java.util.List;

import com.soham.jdbc.Entity.Person;

public interface PersonDao {
	public Person getPerson(int id);
	public List<Person> getAllPerson();
	public Person createPerson(Person person);
	public Person updatePerson(Person person);
	public void deletePerson(int id);
	
	
	

}
