package basic;

import com.api.basic.CommonElements3Arrays;
import junit.framework.TestCase;

import java.util.ArrayList;

public class CommonElements3ArraysTest extends TestCase {

    CommonElements3Arrays myCommonElements;
    protected void setUp() throws Exception{
        myCommonElements = new CommonElements3Arrays();
        super.setUp();
    }

    protected void tearDown() throws Exception {
        myCommonElements = null;
        super.tearDown();
    }

    public void testGetCommonElementsCase1(){
        int arr1[] = {1,5,10,20,40,80};
        int arr2[] = {6,7,20,80,100};
        int arr3[] = {3,4,15,20,30,70,80,120};
        int output[] = {20,80};
        ArrayList<Integer> commonElements = myCommonElements.getCommonElements(arr1,arr2,arr3);
        int outputDataLength = output.length;
        int actualOutputDataLength = commonElements.size();
        assertEquals(outputDataLength,actualOutputDataLength);
        for(int i=0;i<outputDataLength;i++){
            assertEquals(output[i],commonElements.get(i).intValue());
        }

    }
}
