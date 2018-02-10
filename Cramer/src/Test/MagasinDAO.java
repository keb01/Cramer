package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagasinDAO 
{
  private PreparedStatement get_all_magasins;
  
  /**
   * Constructeur.
   * Créé les (le) PreparedStatement relatifs aux magasins. 
   * @param connection La connection vers la base de données.
   * @throws SQLException 
   */
  public MagasinDAO(Connection connection) throws SQLException
  {
	get_all_magasins = connection.prepareStatement("SELECT * FROM Magasin ORDER BY nom");
  }
  
  /**
   * Retourne la liste de l'ensemble des magasins. 
   * @return La liste des magasins.
   * @throws SQLException
   */
  public List<Magasin> getAll() throws SQLException
  {
	List<Magasin> result = new ArrayList<>();
    ResultSet rs = get_all_magasins.executeQuery();
    while(rs.next())
    {
      Magasin magasin = new Magasin();
      magasin.read(rs);
      result.add(magasin);
    }
    rs.close();
    return result;
  }
}
