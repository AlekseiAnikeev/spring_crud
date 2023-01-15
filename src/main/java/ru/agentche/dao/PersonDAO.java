package ru.agentche.dao;

import org.springframework.stereotype.Component;
import ru.agentche.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 27.12.2022
 */
@Component
public class PersonDAO {
    private static int PERSON_ID;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PERSON_ID, "Nikolay", 35, "nikola@gmail.com"));
        people.add(new Person(++PERSON_ID, "Aleksey", 34, "aleks@gmail.com"));
        people.add(new Person(++PERSON_ID, "Oleg", 22, "oleg@gmail.com"));
        people.add(new Person(++PERSON_ID, "Vlad", 26, "vlad@gmail.com"));
        people.add(new Person(++PERSON_ID, "Tom", 29, "tom@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PERSON_ID);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
