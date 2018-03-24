package DAOClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Query {
    private String queryType;
    private String table;
    private String param;
    private Socket s;
    private PrintStream out;
    private InputStreamReader in;

    public Query(){
    	try {
			s = new Socket("localhost", 5001);
			out = new PrintStream(s.getOutputStream());
			in = new InputStreamReader(s.getInputStream());
            
            
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.queryType = "";
        this.table = "";
        this.param = "";
    }
    
    

    public String executeQuery(){
    	String query = "{";
        query += "\"queryType\": \""+queryType+"\",";
        query += "\"table\": \""+table+"\",";
        query += "\"param\": \""+param+"\"";
        query += "}\n";
        System.out.println(query);
        out.print(query);
        
        String line = null;
        try (BufferedReader is = new BufferedReader(in)) {
        	line = is.readLine();
        	System.out.println(line);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return line;
        
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
