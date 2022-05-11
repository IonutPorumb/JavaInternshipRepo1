package day6.lambdaExercise;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Ana", "Constantin", 23, "Oradea");
        Person person12 = new Person("Ana", "Dobrin", 46, "Oradea");
        Person person2 = new Person("Daniel", "Popa", 16, "Iasi");
        Person person3 = new Person("Monica", "Munteanu", 30, "Bucuresti");
        Person person4 = new Person("Mihai", "Lupu", 15, "Oradea");
        Person person5 = new Person("Sergiu", "Potra", 67, "Cluj-Napoca");
        Person person6 = new Person("Stefania", "Marcu", 32, "Cluj-Napoca");
        Person person7 = new Person("Ioana", "Popescu", 27, "Timisoara");
        Person person8 = new Person("Andrei", "Maier", 10, "Brasov");
        Person person9 = new Person("Gheorghe", "Constantin", 65, "Timisoara");
        Person person10 = new Person("David", "Comanescu", 26, "Oradea");
        Person person11 = new Person("Daniel", null, 16, "Iasi");

        List<Person> personList = new ArrayList<>(List.of(person1, person2, person3, person4,
                person5, person6, person7, person8, person9, person10, person11, person12));
        System.out.println(PersonServices.listAllPersonsNames(personList));
        System.out.println(PersonServices.listAllMajorPersons(personList));
        System.out.println(PersonServices.listAllPersonsFromCity(personList, "Oradea"));
        System.out.println(PersonServices.listAllPersonsFrom2Cities(personList, "Oradea", "Cluj-Napoca"));
        System.out.println(PersonServices.listAllPersonsFirstNameCapitalized(personList));
        System.out.println(PersonServices.listAllPersonsFirstNameFirstLetter(personList));
        System.out.println(PersonServices.listAllPersonsBetween18And60(personList));
        System.out.println(PersonServices.listAllPersonsHavingFirstNameWithA(personList));
        System.out.println(PersonServices.listAllPersonsHavingFirstNameUniquely(personList));
        System.out.println(PersonServices.listOfPersonsByFirstNameLastNameAndAge(personList));
        System.out.println(PersonServices.listAllPersonsByFirstName(personList));
        System.out.println(PersonServices.listAllPersonsByLastName(personList));
    }
}
