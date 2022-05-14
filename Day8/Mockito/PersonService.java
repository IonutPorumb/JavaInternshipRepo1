package Day8.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonRepository personRepository;
    ContractService contractService;

    public PersonService(PersonRepository personRepository, ContractService contractService) {
        this.personRepository = personRepository;
        this.contractService = contractService;
    }

    public List<Person> findAllEmployedPersons() {
        List<Person> resultList = new ArrayList<>();
        for (Person p : personRepository.getPersonList()) {
            if (contractService.isEmployed(p.getId())) {
                resultList.add(p);
            }
        }
        return resultList;
    }

    public List<Person> findByName(String name) {

        return personRepository.findByName(name);
    }


}
