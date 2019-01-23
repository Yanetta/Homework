import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import stringWorker.StringChangerService;
import stringWorker.StringLowerUpperService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class stringWorkerTest {
    @Spy
    @InjectMocks
    private StringChangerService stringChangerService;

    @Mock
    private StringLowerUpperService lowerUpperService;

    @Test
    public void testAddStartUpperLower() {
        //when(lowerUpperService.toLower("uuu")).thenReturn("lovervalue");
        //when(lowerUpperService.toUpper("jjj")).thenReturn("UPPERVALUE");
        doReturn("lovervalue").when(lowerUpperService).toLower("uuu");
        doReturn("UPPERVALUE").when(lowerUpperService).toUpper("jjj");

        String expected = "UPPERVALUElovervalue";
        String actual = stringChangerService.addStartUpperInputLower("jjj", "uuu");
        assertEquals(expected, actual);
    }

    @Test
    public void addStartAndEndTest() {

        doReturn("aaaBBB").when(stringChangerService).addStart("aaa", "BBB");
        String actual = stringChangerService.addStartAndEnd("aaa", "ccc", "BBB");
        String expected = "aaaBBBccc";
        assertEquals(expected, actual);
    }

//    @Test
//    public void addStartAndEndUpperTest() {
//
//        doReturn("aaaBBB").when(stringChangerService).addStart("aaa", "BBB");
//        when(lowerUpperService.toUpper("ccc")).thenReturn("UPPERVALUE");
//        String expected = "aaaBBBCCC";
//
//        String actual = stringChangerService.addStartAndEndUpper("aaa", "BBB", "ccc");
//        assertEquals(expected, actual);
//    }

    @Test
    public  void  testAddStartAndEndTotalLower(){
        doReturn("startINPUT").when(stringChangerService).addStart("start", "INPUT");
        stringChangerService.addStartAndEndTotalLower("start","end", "INPUT");
        verify(lowerUpperService).toLower("startINPUTend");
    }


}
