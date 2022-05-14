package Day8.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContractRepository {
    private static List<Contract> contractList;

    public ContractRepository(List<Contract> contractList) {
        ContractRepository.contractList = Objects.requireNonNullElseGet(contractList, ArrayList::new);
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public Contract isEmployed(int personId) {
        return contractList.stream()
                .filter(a -> a.getPersonId() == personId && a.getExpirationDate().isBefore(LocalDateTime.now()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "ContractRepository{" + contractList + "}";
    }
}
