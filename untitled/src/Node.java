import java.util.ArrayList;

public class Node {
    private String value;
    private boolean isVisited;
    ArrayList<Edge> inEdges;
    ArrayList<Edge> outEdges;


    public Node(String value) {
        this.value = value;
        this.isVisited = false;
        this.inEdges = new ArrayList<>();
        this.outEdges = new ArrayList<>();
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<Edge> getInEdges() {
        return inEdges;
    }

    public void setInEdges(ArrayList<Edge> inEdges) {
        this.inEdges = inEdges;
    }
}
