package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Article 
{
  public int id;
  public String image;
  public String nom;
  public int poids;
  public String provenance;
  public int idCategorie;
  public String description;
  
  /*Se lit depuis un resultset*/
  public void read(ResultSet result) throws SQLException {
	  id = result.getInt("id");
	  image = result.getString("image");
	  nom = result.getString("nom");
	  poids = result.getInt("poids");
	  provenance = result.getString("provenance");
	  idCategorie = result.getInt("idCategorie");
	  description = result.getString("description");
  }
  
}
