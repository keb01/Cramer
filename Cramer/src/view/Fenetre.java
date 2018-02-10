package view;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;

import Test.MagasinDAO;
import Test.MySQLConnectionPool;
import Test.MySQLConnectionPool.MySQLConnection;
import Test.Magasin;

public class Fenetre extends JFrame{
	
	/**
	 * Le point d'entr�e du programme.
	 * Cr�� une fenetre et l'affiche. 
	 * @param args 
	 * @throws Throwable
	 */
	public static void main(String args[]) throws SQLException {
		Fenetre f = new Fenetre();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MagasinDAO dao = f.connection().magasinDAO;
		List<Magasin> l = dao.getAll();
		
		f.magasins.setList(l);
		
		f.setVisible(true);
		f.pack();
	}
	
	private MagasinsViewer magasins;
	private ArticlesViewer articles;
	private MySQLConnection connection;
	/**
	 * Le constructeur. 
	 * Cr�� les sous-composants et les ajoutes au contentPane. 
	 * Etablit la connection vers la base de donn�es.
	 */
    public Fenetre()
    {
    	connection = MySQLConnectionPool.instance.acquireConnection();
    	magasins = new MagasinsViewer();
    	articles = new ArticlesViewer();
    	
    	getContentPane().setLayout(new GridLayout(1, 2));
    	getContentPane().add(magasins);
    	getContentPane().add(articles);
    }
    
    /**
     * Accesseur vers le MagasinsViewer. (get)
     * @return le MagasinsViewer.
     */
    public MagasinsViewer magasinsViewer() { return magasins; }
    
    /**
     * Accesseur vers l'ArticlesViewer. (get)
     * @return L'ArticlesViewer. 
     */
    public ArticlesViewer articlesViewer() { return articles; }
    
    /**
     * Accesseur vers la connection vers la base de donn�es. (get)
     * @return La connection vers la base de donn�es.
     */
    public MySQLConnection connection() { return connection; }
}
