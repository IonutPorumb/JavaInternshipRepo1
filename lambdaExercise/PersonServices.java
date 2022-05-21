package day6.lambdaExercise;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class PersonServices {
    private static List<Person> personList = new ArrayList<>();

    public PersonServices(List<Person> personList) {
        PersonServices.personList = personList;
    }


    public static List<String> listAllPersonsNames(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .map(Person::concatFirstNameLastName)
                    .toList();
        }
    }


    public static List<Person> listAllMajorPersons(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .filter(a -> a.getAge() > 18)
                    .toList();
        }
    }

    public static List<Person> listAllPersonsFromCity(List<Person> personList, String city) {
        if (personList == null || city == null) {
            return null;
        } else {
            return personList.stream()
                    .filter(a -> a.getCity().equals(city))
                    .toList();
        }
    }

    public static List<Person> listAllPersonsFrom2Cities(List<Person> personList, String city1, String city2) {
        if (personList == null || city1 == null || city2 == null) {
            return null;
        } else {
            return personList.stream()
                    .filter(a -> a.getCity().equals(city1) || a.getCity().equals(city2))
                    .toList();
        }
    }

    public static List<String> listAllPersonsFirstNameCapitalized(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .map(a -> a.getFirstName().toUpperCase())
                    .toList();
        }
    }

    public static List<String> listAllPersonsFirstNameFirstLetter(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .map(a -> a.getFirstName() + (a.getLastName() == null || a.getLastName().equals("") ? "" : " " +
                            a.getLastName().charAt(0) + "."))
                    .toList();
        }
    }

    public static List<Person> listAllPersonsBetween18And60(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .filter(a -> a.getAge() > 18 && a.getAge() < 60)
                    .toList();
        }
    }

    public static List<Person> listAllPersonsHavingFirstNameWithA(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .filter(a -> a.getFirstName().charAt(0) == 'A')
                    .toList();
        }
    }

//    public static Set<String> listAllPersonsHavingFirstNameUniquely(List<Person> personList) {
//        Set<String> result = personList.stream()
//                .map(Person::getFirstName)
//                .collect(Collectors.toSet());
//        return result;
//    }

    public static List<String> listAllPersonsHavingFirstNameUniquely(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .map(Person::getFirstName)
                    .distinct()
                    .toList();
        }
    }

    public static List<Person> listAllPersonsByFirstName(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .sorted(Comparator.comparing(Person::getFirstName))
                    .toList();
        }
    }

    public static List<Person> listAllPersonsByLastName(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .sorted(Comparator.comparing(Person::getLastName, Comparator
                            .nullsLast(Comparator.comparing(Function.identity()))))
                    .toList();
        }
    }
//    public static List<Person> listOfPersonsByFirstNameLastNameAndAge(List<Person> personList) {
//        return personList.stream()
//                .sorted(Comparator.comparing(Person::getFirstName)
//                        .thenComparing(a -> a.getLastName() == null ? "" : a.getLastName())
//                        .thenComparing(Comparator.comparing(Person::getAge).reversed()))
//                .toList();
//    }

    public static List<Person> listOfPersonsByFirstNameLastNameAndAge(List<Person> personList) {
        if (personList == null) {
            return null;
        } else {
            return personList.stream()
                    .sorted(Comparator.comparing(Person::getFirstName)
                            .thenComparing(Person::getLastName, Comparator.nullsLast(Comparator.comparing(Function.identity())))
                            .thenComparing(Comparator.comparing(Person::getAge).reversed()))
                    .toList();
        }
    }

}



