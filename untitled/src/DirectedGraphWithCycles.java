import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DirectedGraphWithCycles {

    ArrayList<Edge> edges;
    ArrayList<Node> nodes;
    static String filePath = "C:\\Users\\owner\\inteliji project\\untitled\\resources\\array.txt";
    final static String LAST_ASCI_LETTER = "{";


    public DirectedGraphWithCycles() {
        this.edges = new ArrayList<>();
        this.nodes = new ArrayList<>();
    }
    public void addEdge(Node fromNode,Node toNode, int weight)
    {
        Edge edge = new Edge(fromNode,toNode,weight);
        addEdgeToArrayLists(edge,fromNode,toNode);

    }
    public void addEdgeToArrayLists(Edge e, Node from, Node to) {
        from.outEdges.add(e);
        to.inEdges.add(e);
        edges.add(e);
    }

    public void initNodesFromArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            nodes.add(new Node(String.valueOf((char) (i + 97))));

    }

    public static int[][] get_input(){
        try {
            ArrayList<int[]> content = new ArrayList<>();
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] result = data.split(",");
                int [] arr = new int[result.length];
                for (int i = 0; i < result.length; i++) {
                    arr[i] = Integer.parseInt(result[i]);
                }
                content.add(arr);
            }
            myReader.close();
            int [][] res = fillArray(content);
            return res;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }


    private static int[][] fillArray(ArrayList<int[]> content) {
        int [][] result = new int[content.size()][content.get(0).length];
        for (int i = 0; i <content.size() ; i++) {
            for (int j = 0; j <content.get(i).length ; j++) {
                result[i][j] = content.get(i)[j];
            }
        }
        return result;
    }

    private static int[] convertByteToIntArr(String data) {
        int[] result = new int[data.length()];
        for (int i = 0; i <data.length() ; i++) {
            result[i] = Integer.parseInt(String.valueOf(data.charAt(i)));
        }
        return result;
    }

    public static DirectedGraphWithCycles getGraphFromInputArray(){
        int [][] inputArray = get_input();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            nodes.add(new Node(indexToString(i)));
        }
        DirectedGraphWithCycles graph = new DirectedGraphWithCycles();
        graph.nodes.addAll(nodes);
        for (int i= 0;i<inputArray.length;i++){
            for (int j = 0; j < inputArray[i].length; j++) {
                if(inputArray[i][j] != -1){
                    graph.addEdge(nodes.get(i),nodes.get(j),inputArray[i][j]);
                }
            }
        }

        return graph;
    }

    public static String indexToString(int index){
        return String.valueOf((char) (index+97));
    }

    public int stringToIndex(String s){
        return Integer.parseInt(s)-97;
    }

    public void setUnvisitedNodes() {
        for (Node n : nodes)
            n.setVisited(false);

    }

    public void printGraph() {
        System.out.print("nodes: [");
        for (Node n : nodes) {
            System.out.print(n.getValue() + " ,");
        }
        System.out.print("], edges: ");
        for (Edge e : edges) {
            System.out.print("(<" + e.getParentNode().getValue() + " => " + e.getSonNode().getValue() + "> weight: " + e.getWeight() + "), ");
        }

    }

    public static double findMinSon(Node ancestor){
        double minNodeIndex = Double.POSITIVE_INFINITY;
        String currentMinValue = LAST_ASCI_LETTER;
        for (int i = 0; i < ancestor.outEdges.size(); i++) {
                if(!ancestor.outEdges.get(i).getSonNode().isVisited()){
                    if(ancestor.outEdges.get(i).getSonNode().getValue().compareTo(currentMinValue)<0)
                    {
                        minNodeIndex =(double) i;
                        currentMinValue = ancestor.outEdges.get(i).getSonNode().getValue();
                    }
                }
        }
        return minNodeIndex;
    }

}

