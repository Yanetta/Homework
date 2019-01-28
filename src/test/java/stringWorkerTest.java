import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import stringWorker.StringChangerService;
import stringWorker.StringLowerUpperService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class stringWorkerTest {
    @Spy
    @InjectMocks
    private StringChangerService stringChangerService;

    @Mock
    private StringLowerUpperService lowerUpperService;


    @Test
    public void testAddStartUpperInputLowerSpy() {
        doReturn("uuu").when(lowerUpperService).toLower("uuu");
        doReturn("JJJ").when(lowerUpperService).toUpper("jjj");
        String expected = "JJJuuu";
        String actual = stringChangerService.addStartUpperInputLower("jjj", "uuu");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartUpperInputLowerMock() {
        when(lowerUpperService.toLower("uuu")).thenReturn("uuu");
        when(lowerUpperService.toUpper("jjj")).thenReturn("JJJ");
        String expected = "JJJuuu";
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

    @Test
    public void addStartAndEndUpperTest() {
        doReturn("aaaccc").when(stringChangerService).addStart("aaa", "ccc");
        when(lowerUpperService.toUpper("bbb")).thenReturn("BBB");
        String expected = "aaacccBBB";
        String actual = stringChangerService.addStartAndEndUpper("aaa", "bbb", "ccc");
        assertEquals(expected, actual);
    }

    @Test
    public  void  testAddStartAndEndTotalLower(){
        doReturn("startINPUT").when(stringChangerService).addStart("start", "INPUT");
        stringChangerService.addStartAndEndTotalLower("start","end", "INPUT");
        verify(lowerUpperService).toLower("startINPUTend");
    }
}
