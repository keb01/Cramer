package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import Test.Magasin;

/**
 * Cette class est responsable de l'affichage des magasins.
 * Elle délègue une partie de ce travail à la class MagasinsListViewer.
 * Elle ajoute des boutons permettant de passer à la page suivante et précédente.
 * @author BADKOUF
 *
 */
public class MagasinsViewer extends JPanel
{
  private MagasinsListViewer listViewer;
  private int currentPage;
  private List<Magasin> magasins;
  
  /**
   * Le constructeur.
   * Cette class créé les sous composants: le MagasinsListViewer et les deux boutons.
   */
  public MagasinsViewer()
  {
	setLayout(new GridBagLayout());
	listViewer = new MagasinsListViewer();
	
	GridBagConstraints c;
	
	c = new GridBagConstraints();
	c.gridwidth = 2;
	c.weightx = 1;
	c.weighty = 1;
	c.fill = GridBagConstraints.HORIZONTAL;
	
	add(listViewer, c);
	
	c = new GridBagConstraints();
	c.gridy = 1;
	add(create("<", (a) -> previousPage()), c);
	
	c = new GridBagConstraints();
	c.gridy = 1;
	c.gridx = 1;
	c.anchor = GridBagConstraints.EAST;
	add(create(">", (a) -> nextPage()), c);
  }
  
  /**
   * Affiche la page suivante.
   * S'il, n'y a pas de page suivante, rien n'est affiché.
   */
  public void nextPage()
  {
	currentPage++;
	if ( currentPage > 9 ) currentPage = 9;
	listViewer.viewPage(magasins, currentPage);
  }
  
  /**
   * Affiche la page précédente.
   * S'il n'y a pas de page précédente, c'est la première page qui est affichée. 
   */
  public void previousPage()
  {
	currentPage--;
	if ( currentPage < 0 ) currentPage = 0;
	listViewer.viewPage(magasins, currentPage);
  }
  
  /**
   * Permet de définir la totalité des magasins.
   * @param list La totalité des magasins. 
   */
  public void setList(List<Magasin> list)
  {
	magasins = list;
	currentPage = 0;
	listViewer.viewPage(list, currentPage);
  }
  
  /**
   * Accesseur vers le sous-composant "MagasinsListViewer".
   * @return Le sous-composant MagasinsListViewer. 
   */
  public MagasinsListViewer listViewer() { return listViewer; }
  
  /**
   * Créé un bouton et lui affecte l'action passée en paramètre.
   * @param text Le texte du bouton à afficher.
   * @param action L'action à appeler lorsque le bouton est cliqué. 
   * @return
   */
  private JButton create(String text, ActionListener action)
  {
	JButton result = new JButton(text);
	result.addActionListener(action);
	return result;
  }
}
