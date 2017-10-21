package accolitetests;

import com.api.accolite.MaximumJumpCostPrefixStringMatch;
import junit.framework.TestCase;

import java.util.ArrayList;

public class MaximumJumpCostTest extends TestCase {

    public void testGetSubstringMatchIndexes(){
        MaximumJumpCostPrefixStringMatch myJumpMatcher = new MaximumJumpCostPrefixStringMatch();
        String inputTextData[] = {"aaaaaaaaaaaabaaa","qwer","aoksirok",
                                    "aaaaaaaaaaaabaaa","rugiiopklo","abrugiiopkloyurugiiopklo"};
        String inputPatternData[] = {"aaa","asd","ok","aaaaaaa","rugiiopklo","rugiiopklo"};
        int outputData[][] = {{0,1,2,3,4,5,6,7,8,9,13},{},{1,6},{0,1,2,3,4,5},{0},{2,14}};
        int testCases = inputTextData.length;
        for(int m=0;m<testCases;m++){
            ArrayList<Integer> results = myJumpMatcher.getSubstringMatchIndexes(inputTextData[m],inputPatternData[m]);
            int resultsSize = results.size();
            assertEquals(outputData[m].length,resultsSize);
            for(int n=0;n<resultsSize;n++){
                assertEquals(outputData[m][n],results.get(n).intValue());
            }
        }
    }

    public void testGetMaximumJumpCost(){
        MaximumJumpCostPrefixStringMatch myJumpMatcher = new MaximumJumpCostPrefixStringMatch();
    }

    public void testGetMaxCost(){
     boolean indexesInputData[][] = {{true,true,false,true,false,true,true,false,true},{true,false,true},
                                    {false,false,true,true,false}};
     int costsInputData[][] = {{5,3,2,8,10,4,3,2,1},{5,10,15},{5,5,5,5,5}};
     int jumpSizeInputData[] = {2,1,2};
     int costsOutputData[] = {17,5,5};
        MaximumJumpCostPrefixStringMatch myJumpMatcher = new MaximumJumpCostPrefixStringMatch();
        int testCases = jumpSizeInputData.length;
        for(int i=0;i<testCases;i++)
        assertEquals(costsOutputData[i],myJumpMatcher.getMaxCost(indexesInputData[i],costsInputData[i],jumpSizeInputData[i]));
    }
}
