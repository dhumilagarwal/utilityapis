package apitests;
import junit.framework.TestCase;
import com.api.Graph;

import java.util.ArrayList;

public class GraphTest extends TestCase {

    Graph myGraph;
    protected void setUp() throws Exception{
        myGraph = new Graph(10);
        myGraph.addEdge(3,8);
        myGraph.addEdge(8,6);
        myGraph.addEdge(2,5);
        myGraph.addEdge(2,4);
        myGraph.addEdge(2,7);
        myGraph.addEdge(7,2);
        myGraph.addEdge(4,2);
        myGraph.addEdge(5,4);
        myGraph.addEdge(4,7);
        myGraph.addEdge(9,1);
        myGraph.addEdge(8,5);
        myGraph.addEdge(8,3);
        myGraph.addEdge(5,7);
        myGraph.addEdge(6,1);
    }

    protected void tearDown() throws Exception {
        myGraph = null;
        super.tearDown();
    }

    public void testAddEdge(){
        assertEquals(true,myGraph.addEdge(3,8));
        assertEquals(true,myGraph.addEdge(8,6));
        assertEquals(true,myGraph.addEdge(2,5));
        assertEquals(false,myGraph.addEdge(-1,9));
        assertEquals(false,myGraph.addEdge(12,5));
        assertEquals(true,myGraph.addEdge(2,4));
        assertEquals(true,myGraph.addEdge(2,7));
        assertEquals(true,myGraph.addEdge(7,2));
        assertEquals(true,myGraph.addEdge(4,2));
        assertEquals(true,myGraph.addEdge(5,4));
        assertEquals(true,myGraph.addEdge(4,5));
        assertEquals(true,myGraph.addEdge(9,1));
        assertEquals(true,myGraph.addEdge(8,5));
        assertEquals(true,myGraph.addEdge(8,3));
        assertEquals(true,myGraph.addEdge(5,7));
        assertEquals(true,myGraph.addEdge(6,1));

    }

    public void testGetBFSTraversalFromVertex(){
        ArrayList<Integer> traversal = myGraph.getBFSTraversalFromVertex(2);
        assertEquals(4,traversal.size());
        assertEquals(2,traversal.get(0).intValue());
        assertEquals(5,traversal.get(1).intValue());
        assertEquals(4,traversal.get(2).intValue());
        myGraph.addEdge(4,8);
        traversal = myGraph.getBFSTraversalFromVertex(2);
        assertEquals(8,traversal.size());
    }

    public void testGetDFSTraversalFromVertex(){
        ArrayList<Integer> traversal = myGraph.getDFSTraversalFromVertex(2);
        assertEquals(4,traversal.size());
        assertEquals(2,traversal.get(0).intValue());
        assertEquals(7,traversal.get(1).intValue());
        assertEquals(4,traversal.get(2).intValue());
        assertEquals(5,traversal.get(3).intValue());
        myGraph.addEdge(7,8);
        traversal = myGraph.getDFSTraversalFromVertex(2);
        assertEquals(8,traversal.size());
        assertEquals(2,traversal.get(0).intValue());
        assertEquals(7,traversal.get(1).intValue());
        assertEquals(8,traversal.get(2).intValue());
        assertEquals(3,traversal.get(3).intValue());
        assertEquals(6,traversal.get(4).intValue());
        assertEquals(1,traversal.get(5).intValue());
        assertEquals(4,traversal.get(6).intValue());
        assertEquals(5,traversal.get(7).intValue());
    }


    public void testGetAdjacencyList(){
        ArrayList<ArrayList<Integer>> adjacencyList = myGraph.getAdjacencyList();
        int edgesCount=0;
        for(ArrayList<Integer> list : adjacencyList){
            edgesCount += list.size();
        }
        assertEquals(14,edgesCount);
    }

}
