package Day8.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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


//        Mockito.when(personService.findAllEmployedPersons()).thenCallRealMethod();
//        On the Web app simulation add a few more tests in which you use Mockito.verify(), Mockito.times(), ArgumentCaptor.


        Assertions.assertEquals(personRepositoryResult, personService.findAllEmployedPersons());


    }

    @Test
    public void findAllEmployedPersonsFindAPerson_verifyTheMethodsCall() {
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

        List<Person> personRepositoryResult = new ArrayList<>(List.of(
                new Person(123456789, "Radu Popescu", 32)));


        Mockito.when(mockPersonRepository.getPersonList()).thenReturn(personRepositoryResult);
        Mockito.when(mockContractService.isEmployed(123456789)).thenReturn(true);


//        Mockito.when(personService.findAllEmployedPersons()).thenCallRealMethod();
//        On the Web app simulation add a few more tests in which you use Mockito.verify(), Mockito.times(), ArgumentCaptor.


        Assertions.assertEquals(personRepositoryResult, personService.findAllEmployedPersons());
        Mockito.verify(mockPersonRepository, Mockito.times(1)).getPersonList();
        Mockito.verify(mockPersonRepository, Mockito.atMost(4)).getPersonList();
        Mockito.verify(mockContractService, Mockito.times(1)).isEmployed(123456789);
        Mockito.verify(mockContractService, Mockito.atLeast(1)).isEmployed(123456789);

    }

    @Test
    public void findAllEmployedPersonsFindingNoPerson() {
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

        List<Person> personRepositoryResult = new ArrayList<>(List.of(
                new Person(123456789, "Radu Popescu", 32),
                new Person(223456789, "Monica Coman", 32)));


        List<Person> findMethodResult = new ArrayList<>();


        Mockito.when(mockPersonRepository.getPersonList()).thenReturn(personRepositoryResult);
        Mockito.when(mockContractService.isEmployed(123456789)).thenReturn(false);
        Mockito.when(mockContractService.isEmployed(223456789)).thenReturn(false);


        Assertions.assertEquals(findMethodResult, personService.findAllEmployedPersons());


    }

    @Test
    public void findAllEmployedPersonsFindingNoPerson_verifyTheMethodsCall() {
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

        List<Person> personRepositoryResult = new ArrayList<>(List.of(
                new Person(123456789, "Radu Popescu", 32),
                new Person(223456789, "Monica Coman", 32)));


        List<Person> findMethodResult = new ArrayList<>();


        Mockito.when(mockPersonRepository.getPersonList()).thenReturn(personRepositoryResult);
        Mockito.when(mockContractService.isEmployed(123456789)).thenReturn(false);
        Mockito.when(mockContractService.isEmployed(223456789)).thenReturn(false);


        Assertions.assertEquals(findMethodResult, personService.findAllEmployedPersons());

        Mockito.verify(mockPersonRepository, Mockito.atLeast(1)).getPersonList();
        Mockito.verify(mockContractService, Mockito.times(1)).isEmployed(123456789);


    }


    @Test
    public void findAllEmployedPersonsWithMorePersons_usingArgumentCapture() {
        PersonRepository mockPersonRepository = Mockito.mock(PersonRepository.class);
        ContractService mockContractService = Mockito.mock(ContractService.class);

        PersonService personService = new PersonService(mockPersonRepository, mockContractService);

        List<Person> personRepositoryResult = new ArrayList<>(List.of(
                new Person(123456789, "Radu Popescu", 32),
                new Person(223456789, "Monica Coman", 32),
                new Person(323456789, "Radu Mazare", 42)));


        Mockito.when(mockPersonRepository.getPersonList()).thenReturn(personRepositoryResult);
        Mockito.when(mockContractService.isEmployed(123456789)).thenReturn(true);
        Mockito.when(mockContractService.isEmployed(323456789)).thenReturn(true);

        personRepositoryResult.remove(1);

        Assertions.assertEquals(personRepositoryResult, personService.findAllEmployedPersons());
//        Assertions.assertTrue(personService.findAllEmployedPersons().containsAll(findMethodResult));

        Mockito.verify(mockPersonRepository, Mockito.atLeast(1)).getPersonList();
        Mockito.verify(mockContractService, Mockito.times(2)).isEmployed(Mockito.anyInt());
        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(mockContractService, Mockito.times(2)).isEmployed(integerArgumentCaptor.capture());

        List<Integer> actualParameters = new ArrayList<>();
        actualParameters = integerArgumentCaptor.getAllValues();
        System.out.println("The parameters used to call the isEmployed() method are: " + actualParameters);


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

        Mockito.verify(mockPersonRepository, Mockito.times(1)).findByName(personName);
        Mockito.verify(mockContractService, Mockito.times(0)).isEmployed(123456789);


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

        Mockito.verify(mockPersonRepository, Mockito.times(1)).findByName(personName);
        Mockito.verify(mockPersonRepository, Mockito.atMostOnce()).findByName(personName);


    }
}