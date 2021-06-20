package com.soham.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.soham.jdbc.Entity.Person;
@Repository
public class PersonDaoImpl extends NamedParameterJdbcDaoSupport implements PersonDao {

	@Autowired
	DataSource datasource;
	
	@PostConstruct
	public void initilizer()
	{
		setDataSource(datasource);
	}
	@Override
	public Person getPerson(int id) {
		String sql="select * from person where personId=:id";
		Map<String,Object> map=new HashMap<>();
		map.put("id", id);
		Person queryForObject = getNamedParameterJdbcTemplate().queryForObject(sql, map, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person p=new Person();
				p.setPersonId(rs.getInt(1));
				p.setPersonName(rs.getString(2));
				return p;
			}
			
		});
		return queryForObject;
	}

	@Override
	public List<Person> getAllPerson() {
		String sql="select * from person";
		List<Person> list = getNamedParameterJdbcTemplate().query(sql, new BeanPropertyRowMapper<Person>(Person.class));
		return list;
	}

	@Override
	public Person createPerson(Person person) {
		String sql="insert into person values (:id,:name)";
		Map<String ,Object> map=new HashMap<>();
		map.put("id", person.getPersonId());
		map.put("name", person.getPersonName());
		getNamedParameterJdbcTemplate().update(sql, map);
		return person;
	}

	@Override
	public Person updatePerson(Person person) {
		String sql="update person set=:name where personId=:id";
		Map<String ,Object> map=new HashMap<>();
		map.put("id", person.getPersonId());
		map.put("name", person.getPersonName());
		getNamedParameterJdbcTemplate().update(sql, map);
		return person;
	}

	@Override
	public void deletePerson(int id) {
		String sql="delete from person where personId=:id";
		Map<String ,Object> map=new HashMap<>();
		map.put("id", id);
		getNamedParameterJdbcTemplate().update(sql, map);

	}

}
