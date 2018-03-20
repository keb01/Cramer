package DAOClient;

public class Query {
    private String queryType;
    private String table;
    private String param;

    public Query(String queryType,String table, String param){
        this.queryType = queryType;
        this.table = table;
        this.param = param;
    }


}
