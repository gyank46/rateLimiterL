package com.gyan.ratelimiterlld.Service;

import com.gyan.ratelimiterlld.DataAccessLayer.DataAccessInterface;
import com.gyan.ratelimiterlld.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class PersonService {

    @Autowired
    DataAccessInterface repo;

    public void addPerson(Person person){
        UUID id = UUID.randomUUID();
        person.setId(id.toString().replace("-",""));
        if(person.getToken()==Integer.MIN_VALUE)
            person.setToken(10);
        repo.save(person);
    }

    public List<Person> getPersons(){
        List<Person> personList = new ArrayList<Person>();
        repo.findAll().forEach(person->personList.add(person));
        return personList;
    }

    public Person getPerson(String id){
        return repo.findById(id).get();

    }

    public void updatePerson(String id, Person person){
        Person oPerson = getPerson(id);
        if(person.getName()!=null)
            oPerson.setName(person.getName());
        if(person.getToken()!=Integer.MIN_VALUE)
            oPerson.setToken(person.getToken());
        repo.save(oPerson);

    }

    public void deletePerson(String id){
        repo.delete(getPerson(id));
    }

}
