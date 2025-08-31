package app.trialProject.DAO;

import app.trialProject.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_ID = 1;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(PERSON_ID++, "TOM"));
        people.add(new Person(PERSON_ID++, "Mike"));
        people.add(new Person(PERSON_ID++, "Bob"));
        people.add(new Person(PERSON_ID++, "Jack"));
        people.add(new Person(PERSON_ID++, "Jane"));
        people.add(new Person(PERSON_ID++, "John"));
    }

    public List<Person> index() {
        return people;
    }

    public Person getPersonById(long id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
