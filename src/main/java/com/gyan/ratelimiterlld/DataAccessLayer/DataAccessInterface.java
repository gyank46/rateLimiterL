package com.gyan.ratelimiterlld.DataAccessLayer;

import com.gyan.ratelimiterlld.Model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DataAccessInterface extends CrudRepository<Person, String> {


//    public void addPerson(Person person);
//
//    public List<Person> getPersons();
//
//    public Person getPerson(UUID id);
//
//    public void updatePerson(UUID id, HttpServletRequest request);
//
//    public void deletePerson(UUID id);

}
