package pdstest;


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
  public static class MySQLConnection
  {
    public Connection connection;
    public PreparedStatement useStatement;
    
  }
  
  private Deque<MySQLConnection> pool;
  public MySQLConnectionPool()
  {
    pool = new LinkedBlockingDeque<>();
  }
  
  public MySQLConnection acquireConnection()
  {
	    // pollFirst renvoi "null" ou le premier element de la liste.
	    // donc pas d'exception, pas de bloquage.
    MySQLConnection result = pool.pollFirst();
    if ( result == null )
      result = createConnection();
    
    return result;
  }
  
  public void releaseConnection(MySQLConnection c)
  {
    pool.addLast(c);
  }
  
  private MySQLConnection createConnection()
  {
    MySQLConnection result = new MySQLConnection();
    Properties connectionProps = new Properties();
    connectionProps.put("user", "bddcramer");
    connectionProps.put("password", "cramer");
    String addr = "picpicb.ddns.net";
    
    
    
   /* connectionProps.put("user", "root");
    connectionProps.put("password", "");
    addr = "127.0.0.1";*/
    
    try
    {
      result.connection = DriverManager.getConnection(
                   "jdbc:mysql://" +
                   addr +
                   ":" + 5000 + "/",
                   connectionProps);
      
      
      result.connection.createStatement().execute("USE devCramer");
      result.useStatement = result.connection.prepareStatement("SELECT id,nom FROM Personne");
      
      
      return result;
    }
    catch (SQLException ex)
    {
      throw new Error(ex);
    }
  }
  
  public static void main(String args[]) throws SQLException
  {
	  MySQLConnectionPool connectionPool = new MySQLConnectionPool();
	    
	    MySQLConnection msc = connectionPool.acquireConnection();
	    
	    ResultSet rs = msc.useStatement.executeQuery();
	    while(rs.next())
	    {
	      int id= rs.getInt("id");
	      String nom= rs.getString("nom");
	      //, idPersonne, blabla, blablabla
	      System.out.println(id);
	      //System.out.println(nom);
	    }
	    
	    rs.close();
	    connectionPool.releaseConnection(msc);
  }
}
