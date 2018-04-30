package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

//import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class PanelDetailProfil extends JPanel{
	private JLabel nom;
	private JLabel client;
	private JButton suppButton;
	private JButton modifButton;
	private JComboBox<String> comboClient;
	
	public PanelDetailProfil(){
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
		this.client = new JLabel("");

		infoText.add(nom);
		infoText.add(client);
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
	
	
	
	
	public void setListenerSuppButton(ActionListener a) {
		this.suppButton.addActionListener(a);
	}




	public void setListenerModifButton(ActionListener a) {
		this.modifButton.addActionListener(a);
	}




	public void update(String nom,String client, String[] listClient){
		comboClient.setModel(new DefaultComboBoxModel<String>(listClient));
		comboClient.setSelectedItem(client);
		this.nom.setText(nom);;
		this.client.setText("Client "+client);
		this.revalidate();
		this.repaint();
	}
	
	public String getSelectedClient(){
		return comboClient.getSelectedItem().toString();
	}
}