package Strategy;

public class SearchButton {

    private MyProgram myProgram;
    private SearchStrategy searchStrategy = new SearchStrategyAll();

    public SearchButton(MyProgram myProgram) {
        this.myProgram = myProgram;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void onClick() {
        searchStrategy.search();
    }
}
