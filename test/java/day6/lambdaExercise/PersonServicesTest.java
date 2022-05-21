package day6.lambdaExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnit4.class)
class PersonServicesTest {
    List<Person> personList1 = new ArrayList<>();
    List<Person> personList2 = new ArrayList<>();
    List<Person> personListWithNull = new ArrayList<>();
    List<Person> personMajor = new ArrayList<>();
    List<Person> personMajorWithNull = new ArrayList<>();
    List<Person> personFromCity = new ArrayList<>();
    List<Person> personFrom2City = new ArrayList<>();
    List<Person> personsBetween18_60 = new ArrayList<>();
    List<Person> personsFirstNameWithA = new ArrayList<>();
    List<Person> personsWithMultipleTimesOccur = new ArrayList<>();
    List<String> personsWithMultipleTimesOccurResult = new ArrayList<>();
    List<Person> personsByFirstName = new ArrayList<>();
    List<Person> personsByLastName = new ArrayList<>();
    List<Person> istOfPersonsByFirstNameLastNameAndAge1 = new ArrayList<>();
    List<Person> istOfPersonsByFirstNameLastNameAndAge2 = new ArrayList<>();

    @BeforeEach
    public void initMethod() {

        Person person1 = new Person("Ana", "Constantin", 23, "Oradea");
        Person person2 = new Person("Daniel", "Popa", 16, "Iasi");
        Person person3 = new Person("Monica", "Munteanu", 30, "Bucuresti");
        Person person4 = new Person("Mihai", "Lupu", 15, "Oradea");
        Person person5 = new Person("Sergiu", "Potra", 67, "Cluj-Napoca");
        Person person6 = new Person("Stefania", "Marcu", 32, "Cluj-Napoca");
        Person person7 = new Person("Ioana", null, 27, "Timisoara");
        Person person8 = new Person("Andrei", "Maier", 10, "Brasov");
        Person person9 = new Person("Gheorghe", "Constantin", 65, "Timisoara");
        Person person10 = new Person("David", "Comanescu", 26, "Oradea");
        Person person11 = new Person("Daniel", null, 16, "Iasi");
        Person person12 = new Person("Ana", "Dobrin", 46, "Oradea");
        personList1.addAll(List.of(person1, person2, person3, person4, person5));
        personList2.addAll(List.of(person1, person2, person3, person4, person8));
        personListWithNull.addAll(List.of(person1, person2, person3, person4, person7));
        personMajor.addAll(List.of(person1, person3, person5));
        personMajorWithNull.addAll(List.of(person1, person3, person7));
        personFromCity.addAll(List.of(person1, person4));
        personFrom2City.addAll(List.of(person1, person4, person5));
        personsBetween18_60.addAll(List.of(person1, person3));
        personsFirstNameWithA.addAll(List.of(person1, person8));
        personsWithMultipleTimesOccur.addAll(List.of(person1, person11, person2, person12, person1));
        personsWithMultipleTimesOccurResult.addAll(List.of("Ana", "Daniel"));
        personsByFirstName.addAll(List.of(person1, person2, person4, person3, person5));
        personsByLastName.addAll(List.of(person1, person4, person3, person2, person5));
        istOfPersonsByFirstNameLastNameAndAge1.addAll(List.of(person1, person2, person4, person3, person5));
        istOfPersonsByFirstNameLastNameAndAge2.addAll(List.of(person1, person2, person7, person4, person3));
    }

    @Test
    public void listAllPersonsNames_WhenWeHaveANonNullList() {
        List<String> personNames = new ArrayList<>(List.of("Ana Constantin", "Daniel Popa", "Monica Munteanu",
                "Mihai Lupu", "Sergiu Potra"));
        assertTrue(personNames.containsAll(PersonServices.listAllPersonsNames(personList1))
                && personNames.size() == personList1.size());
    }

    @Test
    public void listAllPersonsNames_ifOneNameIsNull() {
        List<String> personNames = new ArrayList<>(List.of("Ana Constantin", "Daniel Popa", "Monica Munteanu",
                "Mihai Lupu", "Ioana null"));
        assertTrue(personNames.containsAll(PersonServices.listAllPersonsNames(personListWithNull))
                && personNames.size() == personListWithNull.size());
    }

    @Test
    public void listAllPersonsNames_whenGivenListIsNull() {
        assertNull(PersonServices.listAllPersonsNames(null));
    }

    @Test
    public void listAllMajorPersons_ifOneNameIsNull() {
        assertTrue(personMajorWithNull.containsAll(PersonServices.listAllMajorPersons(personListWithNull))
                && personMajorWithNull.size() == PersonServices.listAllMajorPersons(personListWithNull).size());
    }

    @Test
    public void listAllMajorPersons_whenGivenListIsNull() {
        assertNull(PersonServices.listAllMajorPersons(null));
    }

    @Test
    public void listAllMajorPersons_WhenWeHaveANonNullList() {
        assertTrue(personMajor.containsAll(PersonServices.listAllMajorPersons(personList1))
                && personMajor.size() == PersonServices.listAllMajorPersons(personList1).size());
    }

    @Test
    public void listAllPersonsFromCity_WhenWeHaveANonNullList() {
        assertTrue(personFromCity.containsAll(PersonServices.listAllPersonsFromCity(personList1, "Oradea"))
                && personFromCity.size() == PersonServices.listAllPersonsFromCity(personList1, "Oradea").size());
    }

    @Test
    public void listAllPersonsFromCity_whenGivenCityIsNull() {
        assertNull(PersonServices.listAllPersonsFromCity(personList1, null));
    }

    @Test
    public void listAllPersonsFrom2Cities_WhenWeHaveANonNullList() {
        assertTrue(personFrom2City.containsAll(PersonServices
                .listAllPersonsFrom2Cities(personList1, "Oradea", "Cluj-Napoca"))
                && personFrom2City.size() == PersonServices
                .listAllPersonsFrom2Cities(personList1, "Oradea", "Cluj-Napoca").size());
    }

    @Test
    public void listAllPersonsFrom2Cities_whenGivenCityIsNull() {
        assertNull(PersonServices.listAllPersonsFrom2Cities(personList1, "Oradea", null));
    }

    @Test
    public void listAllPersonsFirstNameCapitalized_WhenWeHaveANonNullList() {
        List<String> capitalizedPersonFirstName = new ArrayList<>(List.of("ANA", "DANIEL", "MONICA", "MIHAI", "SERGIU"));
        assertTrue(capitalizedPersonFirstName
                .containsAll(PersonServices.listAllPersonsFirstNameCapitalized(personList1))
                && capitalizedPersonFirstName.size() == PersonServices
                .listAllPersonsFirstNameCapitalized(personList1).size());
    }

    @Test
    public void listAllPersonsFirstNameCapitalized_WhenWeHaveANullList() {
        assertNull(PersonServices.listAllPersonsFirstNameCapitalized(null));
    }


    @Test
    public void listAllPersonsFirstNameFirstLetter_WhenWeHaveANonNullList() {
        List<String> listAllPersonsFirstNameFirstLetter = new ArrayList<>(List.of("Ana C.", "Daniel P.", "Monica M.",
                "Mihai L.", "Sergiu P."));
        assertTrue(listAllPersonsFirstNameFirstLetter
                .containsAll(PersonServices.listAllPersonsFirstNameFirstLetter(personList1))
                && listAllPersonsFirstNameFirstLetter.size() == PersonServices
                .listAllPersonsFirstNameFirstLetter(personList1).size());
    }

    @Test
    public void listAllPersonsFirstNameFirstLetter_WhenWeHaveANullList() {
        assertNull(PersonServices.listAllPersonsFirstNameFirstLetter(null));
    }

    @Test
    public void listAllPersonsBetween18And60_WhenWeHaveANonNullList() {
        assertTrue(personsBetween18_60
                .containsAll(PersonServices.listAllPersonsBetween18And60(personList1))
                && personsBetween18_60.size() == PersonServices
                .listAllPersonsBetween18And60(personList1).size());
    }

    @Test
    public void listAllPersonsBetween18And60_WhenWeHaveANullList() {
        assertNull(PersonServices.listAllPersonsBetween18And60(null));
    }

    @Test
    public void listAllPersonsHavingFirstNameWithA_WhenWeHaveANonNullList() {
        assertTrue(personsFirstNameWithA
                .containsAll(PersonServices.listAllPersonsHavingFirstNameWithA(personList2))
                && personsFirstNameWithA.size() == PersonServices
                .listAllPersonsHavingFirstNameWithA(personList2).size());
    }

    @Test
    public void listAllPersonsHavingFirstNameWithA_WhenWeHaveANullList() {
        assertNull(PersonServices.listAllPersonsHavingFirstNameWithA(null));
    }

    @Test
    public void listAllPersonsHavingFirstNameUniquely_WhenWeHaveANonNullList() {
        assertTrue(personsWithMultipleTimesOccurResult
                .containsAll(PersonServices.listAllPersonsHavingFirstNameUniquely(personsWithMultipleTimesOccur))
                && personsWithMultipleTimesOccurResult.size() == PersonServices
                .listAllPersonsHavingFirstNameUniquely(personsWithMultipleTimesOccur).size());
    }

    @Test
    public void listAllPersonsHavingFirstNameUniquely_WhenWeHaveANullList() {
        assertNull(PersonServices.listAllPersonsHavingFirstNameUniquely(null));
    }

    @Test
    public void listAllPersonsByFirstName_WhenWeHaveANonNullList() {
        assertTrue((personsByFirstName.get(0)
                .equals(PersonServices.listAllPersonsByFirstName(personList1).get(0))) &&
                (personsByFirstName.get(1)
                        .equals(PersonServices.listAllPersonsByFirstName(personList1).get(1))) &&
                (personsByFirstName.get(2)
                        .equals(PersonServices.listAllPersonsByFirstName(personList1).get(2))) &&
                (personsByFirstName.get(3)
                        .equals(PersonServices.listAllPersonsByFirstName(personList1).get(3))) &&
                (personsByFirstName.get(4)
                        .equals(PersonServices.listAllPersonsByFirstName(personList1).get(4))));

    }

    @Test
    public void listAllPersonsByFirstName_WhenWeHaveANullList() {
        assertNull(PersonServices.listAllPersonsByFirstName(null));
    }

    @Test
    public void listAllPersonsByLastName_WhenWeHaveANonNullList() {
        assertTrue((personsByLastName.get(0)
                .equals(PersonServices.listAllPersonsByLastName(personList1).get(0))) &&
                (personsByLastName.get(1)
                        .equals(PersonServices.listAllPersonsByLastName(personList1).get(1))) &&
                (personsByLastName.get(2)
                        .equals(PersonServices.listAllPersonsByLastName(personList1).get(2))) &&
                (personsByLastName.get(3)
                        .equals(PersonServices.listAllPersonsByLastName(personList1).get(3))) &&
                (personsByLastName.get(4)
                        .equals(PersonServices.listAllPersonsByLastName(personList1).get(4))));
    }

    @Test
    public void listAllPersonsByLastName_WhenWeHaveANullList() {
        assertNull(PersonServices.listAllPersonsByLastName(null));
    }

    @Test
    public void listOfPersonsByFirstNameLastNameAndAge_WhenWeHaveANonNullList() {
        assertTrue((istOfPersonsByFirstNameLastNameAndAge1.get(0)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personList1).get(0))) &&
                (istOfPersonsByFirstNameLastNameAndAge1.get(1)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personList1).get(1))) &&
                (istOfPersonsByFirstNameLastNameAndAge1.get(2)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personList1).get(2))) &&
                (istOfPersonsByFirstNameLastNameAndAge1.get(3)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personList1).get(3))) &&
                (istOfPersonsByFirstNameLastNameAndAge1.get(4)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personList1).get(4))));
    }
    @Test
    public void listOfPersonsByFirstNameLastNameAndAge_WhenWeHaveANullLastNameInList() {
        assertTrue((istOfPersonsByFirstNameLastNameAndAge2.get(0)
                .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personListWithNull).get(0))) &&
                (istOfPersonsByFirstNameLastNameAndAge2.get(1)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personListWithNull).get(1))) &&
                (istOfPersonsByFirstNameLastNameAndAge2.get(2)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personListWithNull).get(2))) &&
                (istOfPersonsByFirstNameLastNameAndAge2.get(3)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personListWithNull).get(3))) &&
                (istOfPersonsByFirstNameLastNameAndAge2.get(4)
                        .equals(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personListWithNull).get(4))));
    }
    @Test
    public void listOfPersonsByFirstNameLastNameAndAge_WhenWeHaveANullList() {
        assertNull(PersonServices.listOfPersonsByFirstNameLastNameAndAge(null));
    }
}