package client.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	
	public PanelArticle(){
		this.setPreferredSize(new Dimension(400,600));
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(Color.GRAY));
		
		//**************Information about the product***********************
		this.imgArticle = new ImageArticle("Pictures/Articles/pasdimage.png");
		this.nom = new JLabel("");
		this.description = createArea("pas de description", true, 0, null);
		this.prix = new JLabel("");
		this.poids = new JLabel("");
		this.provenance = new JLabel("");
		JPanel info = new JPanel();
		info.setLayout(new BorderLayout());
		nom.setFont(new Font("Helvetica", Font.BOLD, 20));
		prix.setFont(new Font("Helvetica", Font.BOLD, 20));
		prix.setForeground(Color.RED);
		info.add(nom,BorderLayout.NORTH);
		info.add(description,BorderLayout.CENTER);
		//********************************************************************
		
		//********************Price et weight****************************
		JPanel cadreprix = new JPanel();
		cadreprix.setLayout(new BorderLayout());
		cadreprix.add(poids, BorderLayout.WEST);
		cadreprix.add(prix, BorderLayout.EAST);
		cadreprix.add(provenance, BorderLayout.NORTH);
		info.add(cadreprix,BorderLayout.SOUTH);
		//********************************************************************
		
		
		//*********************** Buttons*******************************
		suppButton = new JButton("Supprimer");
		modifButton = new JButton("Modifier");
		JPanel cadreButton = new JPanel();
		cadreButton.add(suppButton);
		cadreButton.add(modifButton);
		//********************************************************************
		
		
		this.add(imgArticle,BorderLayout.NORTH);
		this.add(info,BorderLayout.CENTER);
		this.add(cadreButton,BorderLayout.SOUTH);
		this.setVisible(false);
				
	}
	
	
	
	
	public void setListenerSuppButton(ActionListener a) {
		this.suppButton.addActionListener(a);
	}




	public void setListenerModifButton(ActionListener a) {
		this.modifButton.addActionListener(a);
	}




	public void update(String nom,String description, String img, String provenance, long poids, double prix){
		this.imgArticle.update("Pictures/Articles/"+img);
		this.nom.setText(nom);;
		this.description.setText(description);
		this.prix.setText(String.valueOf(prix));
		this.poids.setText(String.valueOf(poids));
		this.provenance.setText(provenance);
		this.revalidate();
		this.repaint();
	}
	
	
	
	
	
	
	// Textarea made to measure
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
	

}
