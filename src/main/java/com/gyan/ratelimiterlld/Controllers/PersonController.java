package com.gyan.ratelimiterlld.Controllers;


import com.gyan.ratelimiterlld.Model.Person;
import com.gyan.ratelimiterlld.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    PersonService svc;



    @GetMapping("/getAll")
    public List<Person> getPersons(){
        return svc.getPersons();
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable String id){
        return svc.getPerson(id);
    }

    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody Person person){
        if(person.getName()==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide name in body");
        }
        svc.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("User "+ person.getName()+ " added");
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity updatePerson(@PathVariable String id, @RequestBody Person person){
        if(person.getName()==null && person.getToken()==Integer.MIN_VALUE)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        svc.updatePerson(id,person);
        return ResponseEntity.status(HttpStatus.OK).body("User "+ id+ " updated");
    }

    @DeleteMapping("/deletePerson/{id}")
    public void deleteStudent(@PathVariable String id){
        svc.deletePerson(id);

    }




}
