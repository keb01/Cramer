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
    pool = new LinkedBlockingDeque<>(15);
  }
  
  public  Connection acquireConnection()
  {
	    // pollFirst renvoi "null" ou le premier element de la liste.
	    // donc pas d'exception, pas de bloquage.

	Connection result;
    if ( pool.isEmpty()) {
      result = createConnection();
    }else {
    	result = pool.pollFirst();
    }
	return result;
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
  
}
