public class Search {
    static SearchType searchType;

    public Search() {
        this.searchType = null;
    }
    public Search(SearchType searchType) {
        this.searchType = searchType;
    }

    public static String runSearch(Node startNode, Node endNode)
    {
        return searchType.search(startNode, endNode);
    }
    public SearchType getSearcheType() {
        return searchType;
    }

    public void setSearcheType(SearchType searchType) {
        this.searchType = searchType;
    }
}
