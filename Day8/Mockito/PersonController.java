package Day8.Mockito;

import java.time.LocalDateTime;
import java.util.List;

public class PersonController {

    public static void main(String[] args) {
        LocalDateTime employeeTime1 = LocalDateTime.of(2020, 5, 10, 12, 0);
        LocalDateTime employeeTime2 = LocalDateTime.of(2023, 5, 20, 12, 0);
        LocalDateTime employeeTime3 = LocalDateTime.of(2019, 5, 20, 12, 0);
        LocalDateTime employeeTime4 = LocalDateTime.of(2027, 5, 20, 12, 0);
        Contract c1 = new Contract(123456789, employeeTime1);
        Contract c2 = new Contract(223456789, employeeTime2);
        Contract c3 = new Contract(423456789, employeeTime3);
        Contract c4 = new Contract(523456789, employeeTime4);
        System.out.println(c1);


        PersonRepository personRepository = new PersonRepository(
                List.of(new Person(123456789, "Radu Popescu", 32),
                        new Person(723456789, null, 32),
                        new Person(523456789, "Radu Popescu", 38),
                        new Person(223456789, "Ana Popescu", 30),
                        new Person(323456789, "Gheorghe Aurescu", 45),
                        new Person(423456789, "Mihaela Pop", 25)));
        System.out.println("This is the person repository: " + personRepository.getPersonList());

        ContractRepository contractRepository = new ContractRepository(List.of(c1, c2, c2, c3));
        PersonService personService = new PersonService(personRepository, new ContractService(contractRepository));
        System.out.println(contractRepository);

        System.out.println("Calling the Contract repository isEmployed(): " + contractRepository.isEmployed(123456789));
        System.out.println("Calling the Contract service isEmployed(): " + new ContractService(contractRepository).isEmployed(423456789));

        System.out.println("Finding all employed persons: " + personService.findAllEmployedPersons());
        System.out.println("Finding person service findByName(): " + personService.findByName("Bob"));
        System.out.println("Finding a list of persons by name: " + personRepository.findByName("Radu Popescu"));
        System.out.println(personService.findAllEmployedPersons());


    }


}
