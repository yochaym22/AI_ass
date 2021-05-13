public class Edge {
    private Node parentNode;
    private Node sonNode;
    private int weight;

    public Edge(Node parentNode, Node sonNode, int weight) {
        this.parentNode = parentNode;
        this.sonNode = sonNode;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getSonNode() {
        return sonNode;
    }

    public void setSonNode(Node sonNode) {
        this.sonNode = sonNode;
    }
}
