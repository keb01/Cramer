package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Deque;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingDeque;

public class MySQLConnectionPool
{	
  
  private LinkedBlockingDeque<Connection> pool;
  public MySQLConnectionPool()
  {
	int nb_connections = 10;
    pool = new LinkedBlockingDeque<>(nb_connections);
    for(int i= 0; i<nb_connections; i++){
    	pool.addLast(createConnection());
    }
  }
  
  public  Connection acquireConnection()
  {
	  try {
		  return pool.takeFirst();
	  } catch (InterruptedException e){
		  return createConnection();
	  }
	
  }
  
  public void releaseConnection(Connection c)
  {
    pool.addLast(c);
  }
  
  private Connection createConnection()
  {
    Connection result = Database.getConnection(); 
      return result;
    
  }
  
  
  /*
  Every connection needs to have a list of preparedstatement
  
  A preparedstatement is an already compiled sql request 
  The connexion come with its PreparedStatement which will be used by the DAO
  
  
  
  
  
  
   */
  
}
