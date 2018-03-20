package DAOClient;

import org.codehaus.jackson.map.ObjectMapper;

public class Query {
    private String queryType;
    private String table;
    private String param;

    public Query(String queryType,String table, String param){
        this.queryType = queryType;
        this.table = table;
        this.param = param;
    }

    public String executeQuery(){
      String json = "";
        ObjectMapper mapper = new ObjectMapper();
        //mapper.writeValue(jso,this);



        return json;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
