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
    private PrintStream out;
    private InputStreamReader in;
    private BufferedReader is;

    //private ArrayList<String> param; 
    
    
    public Query(){
    	try {
			Socket s = new Socket("localhost", 5000);
			out = new PrintStream(s.getOutputStream());
			in = new InputStreamReader(s.getInputStream());
			is = new BufferedReader(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        
        this.queryType = "";
        this.table = "";
        
        this.param = "";
        //this.param = new ArrayList<String>();
    }
    
    

    public String executeQuery(){
    	String query = "{";
        query += "\"queryType\": \""+queryType+"\",";
        query += "\"table\": \""+table+"\",";
        query += "\"param\": "+param;
        query += "}\n";
        System.out.println("CLIENT QUERY : "+query);
        out.print(query);
        
        String line = null;
       
        	try {
				line = is.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("SERVER RESP : "+line);
    	
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
