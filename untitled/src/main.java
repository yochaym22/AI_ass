import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main
{
    public static void main(String[] args) {

        DirectedGraphWithCycles graph = DirectedGraphWithCycles.getGraphFromInputArray();
        graph.printGraph();
        Search search = new Search(new BfsSearch());
        String s  = search.runSearch(graph.nodes.get(0),graph.nodes.get(4));
        System.out.println(s);


    }


}
