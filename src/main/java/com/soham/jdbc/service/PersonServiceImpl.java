package com.soham.jdbc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soham.jdbc.Entity.Person;
import com.soham.jdbc.dao.PersonDao;
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonDao personDao;

	@Override
	public Person getPerson(int id) {
		Person person = personDao.getPerson(id);
		
		return person;
	}

	@Override
	public List<Person> getAllPerson() {
		List<Person> list = personDao.getAllPerson();
		return list;
	}

	@Override
	public Person createPerson(Person person) {
		Person person2 = personDao.createPerson(person);
		return person2;
	}

	@Override
	public Person updatePerson(Person person) {
		Person updatePerson = personDao.updatePerson(person);
		return updatePerson;
	}

	@Override
	public void deletePerson(int id) {
		personDao.deletePerson(id);


	}

}
