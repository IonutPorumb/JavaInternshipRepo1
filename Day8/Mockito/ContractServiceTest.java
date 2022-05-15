package Day8.Mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
    void isEmployedAndReturnsTrue_verifyTheMethodsCall() {

        ContractRepository mockContractRepository = Mockito.mock(ContractRepository.class);
        ContractService contractService = new ContractService(mockContractRepository);

        Contract returnedContract = new Contract(
                123456789, LocalDateTime.of(2027, 5, 20, 12, 0));

        Mockito.when(mockContractRepository.isEmployed(123456789)).thenReturn(returnedContract);
        boolean resultIsEmployed = contractService.isEmployed(123456789);

        assertTrue(resultIsEmployed);

        Mockito.verify(mockContractRepository, Mockito.times(1)).isEmployed(123456789);
        Mockito.verify(mockContractRepository, Mockito.atMost(0)).getContractList();
        Mockito.verify(mockContractRepository, Mockito.times(1)).isEmployed(Mockito.anyInt());


    }

    @Test
    void isEmployedAndReturnsTrue_usingArgumentCaptor() {

        ContractRepository mockContractRepository = Mockito.mock(ContractRepository.class);
        ContractService contractService = new ContractService(mockContractRepository);

        Contract returnedContract = new Contract(
                123456789, LocalDateTime.of(2027, 5, 20, 12, 0));

        Mockito.when(mockContractRepository.isEmployed(123456789)).thenReturn(returnedContract);
        boolean resultIsEmployed = contractService.isEmployed(123456789);

        assertTrue(resultIsEmployed);


        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(mockContractRepository, Mockito.times(1)).isEmployed(integerArgumentCaptor.capture());

        Integer actualParameter = integerArgumentCaptor.getValue();
        System.out.println("The parameter used to call the isEmployed() method is: " + actualParameter);


    }


    @Test
    void isEmployedAndReturnsFalse() {

        ContractRepository mockContractRepository = Mockito.mock(ContractRepository.class);
        ContractService contractService = new ContractService(mockContractRepository);


        Mockito.when(mockContractRepository.isEmployed(123456789)).thenReturn(null);
        boolean resultIsEmployed = contractService.isEmployed(123456789);
        assertFalse(resultIsEmployed);


    }

    @Test
    void isEmployedAndReturnsFalse_usingArgumentCapture() {

        ContractRepository mockContractRepository = Mockito.mock(ContractRepository.class);
        ContractService contractService = new ContractService(mockContractRepository);


        Mockito.when(mockContractRepository.isEmployed(123456789)).thenReturn(null);
        boolean resultIsEmployed = contractService.isEmployed(123456789);
        assertFalse(resultIsEmployed);
        ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(mockContractRepository, Mockito.times(1)).isEmployed(integerArgumentCaptor.capture());

        Integer parameterValue = integerArgumentCaptor.getValue();

        System.out.println("The parameter used to call the method isEmployed() is : " + parameterValue);


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