public interface SearchType {
    String search(Node startNode, Node endNode);
    boolean reachEndNode = false;
}

class DfsSearch implements SearchType {

    public String search(Node startNode, Node endNode){
        return runDfs(startNode, endNode,"");
    }
    boolean dfsEndReached = reachEndNode;

    private String runDfs(Node startNode, Node endNode, String path) {
        if (dfsEndReached)
            return path + startNode.getValue();
        else {

            if (startNode.equals(endNode)) {
                dfsEndReached = true;
                return path + endNode.getValue();
            }
            for (int i = 0; i < startNode.outEdges.size(); i++) {
                if (!startNode.outEdges.get(i).getSonNode().isVisited()){
                    startNode.outEdges.get(i).getSonNode().setVisited(true);
                    runDfs(startNode.outEdges.get(i).getSonNode(), endNode, path);
                }
            }
        }
      return path;
    }
}

class BfsSearch implements SearchType {

    public String search(Node startNode, Node endNode){
        String res = runBfs(startNode, endNode);
        return res;
    }

    private String runBfs(Node start, Node end) {
//        String result = "";
        //TODO implement BFS
        return null;
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

