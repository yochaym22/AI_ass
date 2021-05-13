import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main
{
    public static void main(String[] args) {

        DirectedGraphWithCycles graph = DirectedGraphWithCycles.getGraphFromInputArray();
        graph.printGraph();
        Search search = new Search(new DfsSearch());
        System.out.println(search.runSearch(graph.nodes.get(1),graph.nodes.get(2)));
    }


}
