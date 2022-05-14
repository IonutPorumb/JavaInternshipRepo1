package Day8.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    @Test
    public void findAllEmployedPersonsFindAPerson() {
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

        List<Person> personRepositoryResult = new ArrayList<>(List.of(
                new Person(123456789, "Radu Popescu", 32)));


        Mockito.when(mockPersonRepository.getPersonList()).thenReturn(personRepositoryResult);
        Mockito.when(mockContractService.isEmployed(123456789)).thenReturn(true);


        Assertions.assertEquals(personRepositoryResult, personService.findAllEmployedPersons());

    }

    @Test
    public void findAllEmployedPersonsFindNoPerson() {
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

        List<Person> personRepositoryResult = new ArrayList<>(List.of(
                new Person(123456789, "Radu Popescu", 32)));

        List<Person> findMethodResult = new ArrayList<>();


        Mockito.when(mockPersonRepository.getPersonList()).thenReturn(personRepositoryResult);
        Mockito.when(mockContractService.isEmployed(123456789)).thenReturn(false);


        Assertions.assertEquals(findMethodResult, personService.findAllEmployedPersons());


    }


    @Test
    public void findByNameUsingAnExistingPerson() {

        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);
        String personName = "Radu Popescu";

        List<Person> expectedResult = new ArrayList<>(List.of(
                new Person(123456789, "Radu Popescu", 32),
                new Person(523456789, "Radu Popescu", 37)));

        Mockito.when(mockPersonRepository.findByName(personName)).thenReturn(expectedResult);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

//        Mockito.when(personService.findByName(personName)).thenCallRealMethod();

        List<Person> personServiceResult = personService.findByName(personName);

        Assertions.assertEquals(expectedResult, personServiceResult);

    }

    @Test
    public void findByNameUsingUnExistingPerson() {

        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);
        String personName = "Bob";

        List<Person> expectedResult = new ArrayList<>();

        Mockito.when(mockPersonRepository.findByName(personName)).thenReturn(expectedResult);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

//        Mockito.when(personService.findByName(personName)).thenCallRealMethod();

        List<Person> personServiceResult = personService.findByName(personName);

        Assertions.assertEquals(expectedResult, personServiceResult);

    }
}