package View;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class PanelDetailBorne extends JPanel{
	private JLabel nom;
	private JLabel zone;
	private JButton suppButton;
	private JButton modifButton;
	private JComboBox<String> comboZone;
	
	public PanelDetailBorne(){
		this.setPreferredSize(new Dimension(400,600));
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(Color.GRAY));
		
		//**************Information Borne***********************
		this.nom = new JLabel("");
		this.zone = new JLabel("");
		JPanel info = new JPanel();
		info.setLayout(new BorderLayout());
		info.add(nom,BorderLayout.NORTH);
		info.add(zone,BorderLayout.CENTER);
		//********************************************************************
        JLabel lbl = new JLabel();
        lbl.setBorder(new LineBorder(Color.RED));
        lbl.setOpaque(true);
        lbl.setIcon(new ImageIcon("Pictures/kiosk.png"));
        info.add(lbl);
        
        
        //***********************Zone modification*******************************
        JPanel modifZone = new JPanel();
        modifZone.setBorder(new LineBorder(Color.RED));
        modifZone.setLayout(new BorderLayout());
        JLabel zoneLbl = new JLabel("Modifier l'emplacement");
        modifButton = new JButton("Appliquer");
        comboZone = new JComboBox<String>();
        modifZone.add(zoneLbl,BorderLayout.NORTH);
        modifZone.add(comboZone,BorderLayout.WEST);
        modifZone.add(modifButton,BorderLayout.EAST);
		
		//***********************Buttons*******************************
		suppButton = new JButton("Supprimer la Borne");
		
		JPanel cadreButton = new JPanel();
		cadreButton.add(suppButton);
		//********************************************************************
		
		this.add(info,BorderLayout.NORTH);
		this.add(modifZone,BorderLayout.CENTER);
		this.add(cadreButton,BorderLayout.SOUTH);
		this.setVisible(true);
				
	}
	
	
	
	
	public void setListenerSuppButton(ActionListener a) {
		this.suppButton.addActionListener(a);
	}




	public void setListenerModifButton(ActionListener a) {
		this.modifButton.addActionListener(a);
	}




	public void update(String nom,String zone, String[] listZone){
		comboZone.setModel(new DefaultComboBoxModel<String>(listZone));
		this.nom.setText(nom);;
		this.zone.setText(zone);
		this.revalidate();
		this.repaint();
	}
	

}