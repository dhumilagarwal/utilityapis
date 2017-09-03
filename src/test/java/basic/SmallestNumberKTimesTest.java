package basic;
import com.api.basic.SmallestNumberKTimes;
import junit.framework.TestCase;

public class SmallestNumberKTimesTest extends TestCase {

    SmallestNumberKTimes mySmallest;
    protected void setUp() throws Exception{
        mySmallest = new SmallestNumberKTimes();
    }

    protected void tearDown() throws Exception {
        mySmallest = null;
        super.tearDown();
    }

    public void testGetSmallestNumberOccuringKTimes(){
        int arrayData[][] = {{2,2,1,3,1},{5,4,10,4,4,5,5,5,4,11,13,13},{},{3,6,8,6,11,6}};
        int kData[] = {2,4,5,2};
        int outputData[] = {1,4,-1,-1};
        int testCasesCount = arrayData.length;
        for(int i=0;i<testCasesCount;i++){
            assertEquals("Failed test Case "+i,outputData[i],mySmallest.getSmallestNumberOccuringKTimes(arrayData[i],kData[i]));
        }
    }
}
