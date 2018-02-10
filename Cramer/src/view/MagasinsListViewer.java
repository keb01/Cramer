package view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Test.Article;
import Test.Magasin;

public class MagasinsListViewer extends JPanel
{
  public MagasinsListViewer()
  {
	setLayout(new GridLayout(0, 1)); // une colonne, X lignes
  }
  
  /**
   * Affiche la ligne des magasins.
   * @param magasins La liste des magasins à afficher. 
   */
  public void view(List<Magasin> magasins)
  {
	  // on remplace = on vire ce qu'il y avait, on en met d'autres
	removeAll(); 
	for ( Magasin m : magasins )
	{
      add(new SingleMagasinViewer(m));
	}
  }
  
  
  /**
   * Affiche une partie de la liste des magasins.
   * La partie affichée correspond à la page passée en paramètre.
   * Il y a 10 éléments par page. 
   * Si la page contient moins de dix éléments, elle affiche moins de dix éléments.
   * @param magasins La totalité des magasins.
   * @param page La page à afficher. 
   */
  public void viewPage(List<Magasin> magasins, int page)
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
    repaint();
  }
  
  /**
   * Est responsable de l'affichage d'un magasin.
   * Lorsque l'utilisateur clique sur cet élément, la liste des articles de ce magasin est affichée. 
   * @author BADKOUF
   *
   */
  private class SingleMagasinViewer extends JLabel
  {
	private Magasin magasin;
	public SingleMagasinViewer(Magasin magasin)
	{
		super(magasin.nom);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Fenetre fenetre = (Fenetre)getTopLevelAncestor();
				List<Article> l;
				try {
					l = fenetre.connection().articleDAO.getAll(magasin.id);
					fenetre.articlesViewer().view(l);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
  }
}
