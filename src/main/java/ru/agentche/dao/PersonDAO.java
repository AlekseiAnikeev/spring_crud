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
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PERSON_ID, "Nikolay"));
        people.add(new Person(++PERSON_ID, "Aleksey"));
        people.add(new Person(++PERSON_ID, "Oleg"));
        people.add(new Person(++PERSON_ID, "Vlad"));
        people.add(new Person(++PERSON_ID, "Tom"));
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
}
