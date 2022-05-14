package Day8.Mockito;

public class ContractService {
    ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
            this.contractRepository = contractRepository;
    }

    public boolean isEmployed(int personId) {
        if (contractRepository != null) {
            return contractRepository.isEmployed(personId) != null;
        }
        return false;
    }

}
