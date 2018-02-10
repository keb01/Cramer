package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArticleDAO 
{
  private PreparedStatement get_all_articles_by_magasin;
  
  /**
   * Constructeur.
   * Cr�� les (le) PreparedStatement relatifs aux Articles.
   * @param connection La connexion vers la base de donn�es.
   * @throws SQLException
   */
  public ArticleDAO(Connection connection) throws SQLException
  {
	get_all_articles_by_magasin = connection.prepareStatement(
    "SELECT * FROM StockMagasin, Article "+
	"WHERE StockMagasin.`idArticle` = Article.id "+
    "AND idMagasin=? ");
  }
  
  /**
   * Retourne la liste de tous les articles pr�sents dans un magasins.
   * @param magasinId L'identifiant du magasin dans la base de donn�es.
   * @return La liste des articles pr�sent dans le magasin.
   * @throws SQLException
   */
  public List<Article> getAll(int magasinId) throws SQLException
  {
	List<Article> result = new ArrayList<>();
	get_all_articles_by_magasin.setInt(1, magasinId);
    ResultSet rs = get_all_articles_by_magasin.executeQuery();
    while(rs.next())
    {
      Article article = new Article();
      article.read(rs);
      result.add(article);
    }
    rs.close();
    return result;
  }
}