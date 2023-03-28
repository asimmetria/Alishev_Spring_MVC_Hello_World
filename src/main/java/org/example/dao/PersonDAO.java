package org.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.example.models.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "name1"));
        people.add(new Person(++PEOPLE_COUNT, "name2"));
        people.add(new Person(++PEOPLE_COUNT, "name3"));
        people.add(new Person(++PEOPLE_COUNT, "name4"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
