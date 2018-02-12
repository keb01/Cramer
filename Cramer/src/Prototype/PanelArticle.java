package Prototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class PanelArticle extends JPanel{
	private ImageArticle imgArticle;
	private JLabel nom;
	private JTextArea description;
	private JLabel prix;
	private JLabel poids;
	private JLabel provenance;
	private JButton suppButton;
	private JButton modifButton;
	private ElementDeListe produit;
	private Contenant contenant;
	
	
	/*public PanelArticle(){
		this.setSize(400,600);
		this.imgArticle = new ImageArticle("Pictures/Articles/pasdimage.png");
		this.nom = new JLabel("Nom Du Produit");
		this.description = createArea("description du produit", true, 0, null);
		this.prix = new JLabel("666€");
		this.poids = new JLabel("Poids : 1000");
		this.provenance = new JLabel("Provenance : Mars");
		this.setLayout(new BorderLayout());
		JPanel info = new JPanel();
		info.setBorder(new LineBorder(Color.BLUE));
		//info.setLayout(new BoxLayout(info,BoxLayout.PAGE_AXIS));
		info.setLayout(new BorderLayout());
		nom.setBorder(new LineBorder(Color.RED));
		nom.setFont(new Font("Helvetica", Font.BOLD, 20));
		prix.setFont(new Font("Helvetica", Font.BOLD, 20));
		prix.setForeground(Color.RED);
	}*/
	
	
	public PanelArticle(ElementDeListe e, Contenant c){
		// remplissage des éléments
		this.contenant=c;
		this.produit = e;
		this.imgArticle = new ImageArticle("Pictures/Articles/"+((Produit) produit.getObjet()).getUrlImage());
		this.nom = new JLabel(((Produit) produit.getObjet()).getNom(),SwingConstants.CENTER);
		this.description = createArea(((Produit) produit.getObjet()).getDescription(), true, 0, null);
		this.prix = new JLabel(String.valueOf(((Produit) produit.getObjet()).getPrix())+"€");
		this.poids = new JLabel("Poids : "+String.valueOf(((Produit) produit.getObjet()).getPoids()));
		this.provenance = new JLabel("Provenance : "+((Produit) produit.getObjet()).getProvenance());
		
		this.setLayout(new BorderLayout());
		JPanel info = new JPanel();
		info.setBorder(new LineBorder(Color.BLUE));
		//info.setLayout(new BoxLayout(info,BoxLayout.PAGE_AXIS));
		info.setLayout(new BorderLayout());
		nom.setBorder(new LineBorder(Color.RED));
		nom.setFont(new Font("Helvetica", Font.BOLD, 20));
		prix.setFont(new Font("Helvetica", Font.BOLD, 20));
		prix.setForeground(Color.RED);
		//nom.setMaximumSize(new Dimension(Integer.MAX_VALUE, nom.getMinimumSize().height));
		//nom.setAlignmentY(Component.LEFT_ALIGNMENT);
		
		info.add(nom,BorderLayout.NORTH);
		info.add(description,BorderLayout.CENTER);
		
		//info.add(prix);
		//info.add(poids);
		//info.add(provenance);
		JPanel cadreprix = new JPanel();
		cadreprix.setBorder(new LineBorder(Color.GREEN));
		cadreprix.setLayout(new BorderLayout());
		cadreprix.add(poids, BorderLayout.WEST);
		cadreprix.add(prix, BorderLayout.EAST);
		cadreprix.add(provenance, BorderLayout.NORTH);
		info.add(cadreprix,BorderLayout.SOUTH);
		
		
		
		
		suppButton = new JButton("Supprimer");
		modifButton = new JButton("Modifier");
		modifButton.addActionListener(new ListenerModifArticle(this));
		
		
		JPanel cadreButton = new JPanel();
		cadreButton.setBorder(new LineBorder(Color.BLACK));
		cadreButton.add(suppButton);
		cadreButton.add(modifButton);
		
		this.add(imgArticle,BorderLayout.NORTH);
		this.add(info,BorderLayout.CENTER);
		this.add(cadreButton,BorderLayout.SOUTH);
				
	}
	
	public void afficher(){
		
		this.nom.setText(((Produit) produit.getObjet()).getNom());
		
	}
	
	
	private JTextArea createArea(
            String text,
            boolean lineWrap, 
            int columns,
            Dimension minimumSize) {
        JTextArea area  = new JTextArea(text);
        area.setEditable(false);
        area.setBackground(UIManager.getColor ( "Panel.background" ));
        area.setBorder(null);
        area.setLineWrap(lineWrap);
        area.setWrapStyleWord(true);
        area.setColumns(columns);
        if (minimumSize != null) {
            area.setMinimumSize(new Dimension(100, 32));
        }
        return area;
    }
	
	public Produit getProduit(){
		return ((Produit) produit.getObjet());
	}




	public void modifierArticle(String text) {
		
		Produit newp = new Produit(((Produit) produit.getObjet()).getId(), 
				text, 
				((Produit) produit.getObjet()).getDescription(), 
				((Produit) produit.getObjet()).getUrlImage(),
				((Produit) produit.getObjet()).getPoids(), 
				((Produit) produit.getObjet()).getProvenance(), 
				((Produit) produit.getObjet()).getCategorie(), 
				((Produit) produit.getObjet()).getPrix());
		
		
		//((Produit) produit.getObjet()).setNom(text);
		ProduitDAO pDAO = new ProduitDAO();
		
		produit.ModifElement(pDAO.update(newp));
		
		System.out.println("FINI DE CHARGE : "+((Produit) produit.getObjet()).getNom());
		afficher();
	
		//contenant.getP2().getListe().remove(produit);
		//contenant.getP2()
		contenant.getP2().revalidate();
		contenant.getP2().repaint();
	}
	
	
	public void supprimerArticle(){
		ProduitDAO pDAO = new ProduitDAO();
		pDAO.delete(((Produit) produit.getObjet()));
		this.setVisible(false);
		contenant.getContainerArticle().removeAll();
	}


}
