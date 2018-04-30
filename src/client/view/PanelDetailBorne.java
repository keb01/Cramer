package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
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
		JPanel infoText = new JPanel();
		Border border = infoText.getBorder();
		Border margin = new EmptyBorder(20,10,10,10);
		infoText.setBorder(new CompoundBorder(border, margin));
		infoText.setLayout(new BoxLayout(infoText, BoxLayout.Y_AXIS));
		this.nom = new JLabel("");
		nom.setFont(new Font("Helvetica", Font.BOLD, 20));
		this.zone = new JLabel("");

		infoText.add(nom);
		infoText.add(zone);
		//********************************************************************
		JPanel info = new JPanel();
		info.setLayout(new BorderLayout());
        JLabel lbl = new JLabel();
        
        lbl.setOpaque(true);
        lbl.setIcon(new ImageIcon("Pictures/kiosk.png"));
        info.add(lbl,BorderLayout.WEST);
        info.add(infoText,BorderLayout.CENTER);
        
        //***********************Area modification*******************************
        JPanel modifZone = new JPanel();
        modifZone.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        modifZone.setLayout(new BorderLayout());
        JLabel zoneLbl = new JLabel("Modifier l'emplacement");
        modifButton = new JButton("Appliquer");
        comboZone = new JComboBox<String>();
        JPanel modifZoneSelect = new JPanel();
        modifZoneSelect.add(comboZone);
        modifZoneSelect.add(modifButton);
        modifZone.add(zoneLbl,BorderLayout.NORTH);
        modifZone.add(modifZoneSelect,BorderLayout.WEST);
		
		//***********************Buttons*******************************
		suppButton = new JButton("Supprimer la Borne");
		
		JPanel cadreButton = new JPanel();
		cadreButton.add(suppButton);
		//********************************************************************
		
		this.add(info,BorderLayout.NORTH);
		this.add(modifZone,BorderLayout.CENTER);
		this.add(cadreButton,BorderLayout.SOUTH);
		this.setVisible(false);
				
	}
	
	
	
	
	public void setListenerSuppButton(ActionListener a) {
		this.suppButton.addActionListener(a);
	}




	public void setListenerModifButton(ActionListener a) {
		this.modifButton.addActionListener(a);
	}




	public void update(String nom,String zone, String[] listZone){
		comboZone.setModel(new DefaultComboBoxModel<String>(listZone));
		comboZone.setSelectedItem(zone);
		this.nom.setText(nom);
		this.zone.setText("Zone "+zone);
		this.revalidate();
		this.repaint();
	}
	
	public String getSelectedZone(){
		return comboZone.getSelectedItem().toString();
	}
}