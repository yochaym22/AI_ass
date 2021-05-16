import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public interface SearchType {
    String search(Node startNode, Node endNode);
    boolean reachEndNode = false;
}

class DfsSearch implements SearchType {

    public String search(Node startNode, Node endNode){
        return runDfs(startNode, endNode, "");
    }
    boolean dfsEndReached = reachEndNode;

    private String runDfs(Node startNode, Node endNode, String path) {
        startNode.setVisited(true);
        if (dfsEndReached)
            return path + startNode.getValue();
        else {

            if (startNode.equals(endNode)) {
                dfsEndReached = true;
                return path + endNode.getValue();
            }
            else {
                for (int i = 0; i < startNode.outEdges.size(); i++) {
                    if (!startNode.outEdges.get(i).getSonNode().isVisited())
                        if(dfsEndReached)
                            break;
                        path = runDfs(startNode.outEdges.get(i).getSonNode(), endNode, path);

                }
                if (dfsEndReached)
                    return path + startNode.getValue();
                return "";
            }

        }
    }
}

class BfsSearch implements SearchType {

    Queue<Node> queue = new LinkedList<>();
    boolean reachedEndNode = false;
    String path = "";
    public String search(Node startNode, Node endNode){
        String res = runBfs(startNode, endNode);
        return res;
    }

    private String runBfs(Node start, Node end) {
        if(start.getValue() == end.getValue())
            return "";
        queue.add(start);
        start.setVisited(true);
        while ((queue.isEmpty())||(reachedEndNode))
        {
            Node curr = queue.poll();
            if(curr.getValue() == end.getValue())
                return path + curr.getValue();
            for (int i = 0;i <curr.outEdges.size();i++){
                if(!curr.outEdges.get(i).getSonNode().isVisited()){
                    if(curr.outEdges.get(i).getSonNode().getValue() == end.getValue()) {
                        reachedEndNode = true;
                        break;
                    }
                    curr.outEdges.get(i).getSonNode().setVisited(true);
                    ArrayList<Edge> newInEdgesList = new ArrayList<>();
                    newInEdgesList.add(curr.outEdges.get(i));
                    curr.outEdges.get(i).getSonNode().setInEdges(newInEdgesList);
                    queue.add(curr.outEdges.get(i).getSonNode());
                }
            }
        }
        StringBuilder res = new StringBuilder();
//        for (Node i = end; i!= null ; i=i.inEdges.get(0).getParentNode())
        Node curr = end;
        while (curr.getInEdges().size() > 0) {
            res.append(curr.getValue());
            curr = curr.inEdges.get(0).getParentNode();
        }
        if(curr.getValue()== start.getValue()) {
            res.append(curr.getValue());
            res.reverse();
            return res.toString();
        }
        else
            return res.append("no path").toString();
    }
}

class UcsSearch implements SearchType {

    public String search(Node startNode, Node endNode){
//        String res = runUcs(start, end, graph);
        //TODO implement UCS
        return null;
    }

    private String runUcs(Node start, Node end, DirectedGraphWithCycles graph) {
//        String result = "";
        return null;
    }
}

