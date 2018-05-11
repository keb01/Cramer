package client.view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
//import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class PanelDetailRedevance extends JPanel{
	private JLabel redevance;
	private JLabel formule;
	private JComboBox<String> comboRedevance;
	
	public PanelDetailRedevance(){
		this.setPreferredSize(new Dimension(400,600));
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(Color.GRAY));
		
		//**************Information Borne***********************
		JPanel infoText = new JPanel();
		Border border = infoText.getBorder();
		Border margin = new EmptyBorder(20,10,10,10);
		infoText.setBorder(new CompoundBorder(border, margin));
		infoText.setLayout(new BoxLayout(infoText, BoxLayout.Y_AXIS));
		this.redevance = new JLabel("");
		redevance.setFont(new Font("Helvetica", Font.BOLD, 20));
		this.formule = new JLabel("");

		infoText.add(redevance);
		infoText.add(formule);
		//********************************************************************
		JPanel info = new JPanel();
		info.setLayout(new BorderLayout());
        JLabel lbl = new JLabel();
        
        lbl.setOpaque(true);
        //lbl.setIcon(new ImageIcon("Pictures/kiosk.png"));
        info.add(lbl,BorderLayout.WEST);
        info.add(infoText,BorderLayout.CENTER);
		
		//********************************************************************
				
	}
	
	public String getSelectedMagasin(){
		return comboRedevance.getSelectedItem().toString();
	}
}