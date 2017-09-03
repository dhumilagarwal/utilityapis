package npat2017tests;

import com.api.npat2017.MostFreq;
import junit.framework.TestCase;

public class MostFreqTest extends TestCase {

    protected void setUp() throws Exception{
        super.setUp();
    }

    protected void tearDown() throws Exception{
        super.tearDown();
    }
    public void testMostFreqCase1(){
        int b[] = new int[3];
        int a[] = {1,2,3,1,2,3,3,3,2,3,4};
        MostFreq.mostFreq3(a,a.length,b);
        assertEquals(3,b[0]);
        assertEquals(2,b[1]);
        assertEquals(1,b[2]);
    }

    public void testMostFreqCase2(){
        int b[] = new int[3];
        int a[] = {4,3,3,2,4,3,4,4,2,1};

        MostFreq.mostFreq3(a,a.length,b);
        assertEquals(4,b[0]);
        assertEquals(3,b[1]);
        assertEquals(2,b[2]);
    }

    public void testMostFreqCase3(){
        int b[] = new int[3];
        int a[] = {1,-1,3,4,4,3,2,1,4,3,2,1,4,4,3};
        MostFreq.mostFreq3(a,a.length,b);
        assertEquals(4,b[0]);
        assertEquals(3,b[1]);
        assertEquals(1,b[2]);
    }

    public void testMostFreqCase4(){
        int b[] = new int[3];
        int a[] = {5,5,5,5,5,3,3,3,4,4,4,4,1,1,2};
        MostFreq.mostFreq3(a,a.length,b);
        assertEquals(5,b[0]);
        assertEquals(4,b[1]);
        assertEquals(3,b[2]);
    }

    public void testMostFreqCase5(){
        int b[] = new int[3];
        int a[] = {1,2,3,4,4,4,4,3,3,2};
        MostFreq.mostFreq3(a,a.length,b);
        assertEquals(4,b[0]);
        assertEquals(3,b[1]);
        assertEquals(2,b[2]);
    }

    public void testMostFreqCase6(){
        int b[] = new int[3];
        int a[] = {6,6,6,6,6,7,7,7,7,1,2,3,4,10,16,17,8,8,8,2};
        MostFreq.mostFreq3(a,a.length,b);
        assertEquals(6,b[0]);
        assertEquals(7,b[1]);
        assertEquals(8,b[2]);
    }
}
