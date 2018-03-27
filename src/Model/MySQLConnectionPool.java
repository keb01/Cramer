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
	int nb_connections = 1;
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
  Chaque connexion doit avoir une liste de preparedstatement
  
  Un preparedstatement c('est quoi ?
  C'est : une requète sql "pré-compilée". 
  
  La connexion vient donc avec ses PreparedStatement que les DAO vont utiliser
  
  
  
  
   */
  
}
