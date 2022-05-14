package Day8.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonRepository {
    private static List<Person> personList;

    public PersonRepository(List<Person> personList) {
        PersonRepository.personList = Objects.requireNonNullElseGet(personList, ArrayList::new);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Person> findByName(String name) {
        return personList.stream()
                .filter(p -> p.getName().equals(name))
                .toList();
    }

    public Person findById(int id) {
        return personList.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElse(null);
    }


    @Override
    public String toString() {
        return "PersonRepository{" + personList + "}";
    }
}
