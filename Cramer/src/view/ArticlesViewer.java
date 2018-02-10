package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Test.Article;

public class ArticlesViewer extends JPanel
{
	/**
	 * Constructer.
	 * Définit le layout du composant (=une colonne). 
	 */
	  public ArticlesViewer()
	  {
		setLayout(new GridLayout(0, 1));
	  }
	  
	  /**
	   * Affiche les articles passés en paramètre.
	   * @param articles Les articles à afficher. 
	   */
	  public void view(List<Article> articles)
	  {
		removeAll();
		for ( Article m : articles )
		{
	      add(new JLabel(m.nom));
		}
		validate();
		repaint();
	  }
	  
	  
	  
	  /*public void viewPage(List<Article> articles, int page)
	  {
	    int page_size = 10;
	    int begin = page * page_size;
	    int end = (page+1) * page_size;
	    
	    end = Math.min(end, magasins.size());
	    List<Magasin> liste_de_la_page = new ArrayList<>();
	    for ( int i = begin; i < end; i++ )
	    	liste_de_la_page.add(magasins.get(i));
	    
	    view(liste_de_la_page);
	    validate();
	  }*/


}
