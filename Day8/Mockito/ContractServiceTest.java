package Day8.Mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class ContractServiceTest {


    @Test
    void isEmployedAndReturnsTrue() {

        ContractRepository mockContractRepository = Mockito.mock(ContractRepository.class);
        ContractService contractService = new ContractService(mockContractRepository);

        Contract returnedContract = new Contract(
                123456789, LocalDateTime.of(2027, 5, 20, 12, 0));

        Mockito.when(mockContractRepository.isEmployed(123456789)).thenReturn(returnedContract);
        boolean resultIsEmployed = contractService.isEmployed(123456789);
        assertTrue(resultIsEmployed);

    }


    @Test
    void isEmployedAndReturnsFalse() {

        ContractRepository mockContractRepository = Mockito.mock(ContractRepository.class);
        ContractService contractService = new ContractService(mockContractRepository);


        Mockito.when(mockContractRepository.isEmployed(123456789)).thenReturn(null);
        boolean resultIsEmployed = contractService.isEmployed(123456789);
        assertFalse(resultIsEmployed);

    }
}

//@RunWith(MockitoJUnitRunner.class)
//class ContractServiceTest {
//
//    @InjectMocks
//    ContractService contractService;
//
//    @Mock
//    ContractRepository contractRepository;
//
//    @Before
//    public void initialization() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void isEmployedAndReturnsTrue() {
//
//        Contract returnedContract = new Contract(
//                123456789, LocalDateTime.of(2027, 5, 20, 12, 0));
//
//        Mockito.when(contractRepository.isEmployed(123456789)).thenReturn(returnedContract);
//        boolean resultIsEmployed = contractService.isEmployed(123456789);
//        assertTrue(resultIsEmployed);
//
//    }
//}