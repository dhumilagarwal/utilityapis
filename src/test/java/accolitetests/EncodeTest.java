package accolitetests;

import com.api.accolite.Encode;
import junit.framework.TestCase;
public class EncodeTest extends TestCase {

    public void testGetDecryptedCode(){
        Encode myEncoder = new Encode();
        String inputData[] = {"dcebfag","cdbeaf","a","ab","bac"};
        String outputData[] = {"abcdefg","abcdef","a","ab","abc"};
        int testCasesCount = inputData.length;
        for(int i=0;i<testCasesCount;i++){
            assertEquals(outputData[i],myEncoder.getDecryptedCode(inputData[i]));
        }
    }
}
