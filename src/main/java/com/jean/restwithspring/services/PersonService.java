package com.jean.restwithspring.services;

import com.jean.restwithspring.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {

        logger.info("finding all people!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {

        logger.info("finding one person!");

        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("jean");
        person.setLastName("borges");
        person.setAddress("presidente prudente - são paulo");
        person.setGender("male");
        return person;
    }

    public Person create(Person person) {

        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {

        logger.info("updating one person!");
        return person;
    }

    public void delete(String id) {

        logger.info("deleting one person!");
    }

    private Person mockPerson(int i) {

        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("person name " + i);
        person.setLastName("last name " + i);
        person.setAddress("some address in brazil " + i);
        person.setGender("male");
        return person;
    }
}
