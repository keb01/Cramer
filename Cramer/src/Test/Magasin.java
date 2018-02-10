package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Magasin 
{
  public int id;
  public String logo;
  public String nom;
  public int idEmplacement;
  public int idCategorieMagasin;
  public String description;
  
  /*Se lire depuis la ligne courante du resultset*/
  public void read(ResultSet s) throws SQLException
  {
	id = s.getInt("id");
	logo = s.getString("logo");
	nom = s.getString("nom");
	idEmplacement = s.getInt("idEmplacement");
	idCategorieMagasin = s.getInt("idCategorieMagasin");
	description = s.getString("description");
  }
}
