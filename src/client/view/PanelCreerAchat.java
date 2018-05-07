package client.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCreerAchat extends JPanel
{
  private JComboBox fournisseurs;
  private JTextField total;
  private JButton ajouter;
  
  public PanelCreerAchat()
  {
	 setLayout(new FlowLayout());
	 
	 fournisseurs = new JComboBox<>();
	 total = new JTextField();
	 ajouter = new JButton("Ajouter");
	 
	 add(fournisseurs);
	 add(total);
	 add(ajouter);
  }
  
  
  
}
