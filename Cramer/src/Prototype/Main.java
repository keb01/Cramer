package Prototype;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main {


	
	
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Fenetre f = new Fenetre();
		f.setLayout(new BorderLayout());
		Contenant contenant = new Contenant();
		
		f.add(contenant);
		
		
		
		
		
		MagasinDAO dao = new MagasinDAO();
		ArrayList<Magasin> listeMagasins = new ArrayList<Magasin>();
		
		listeMagasins = dao.getAllMagasins();
		
		for(Magasin m : listeMagasins  ) {
			//dao.getListeProduit(m);
			ElementDeListe panel = new ElementDeListe(m);
			panel.addMouseListener(new ListenerMagasin(contenant,panel));
			contenant.getP1().remplissage(panel);
		}
		contenant.getP1().affichage();
		
		
		
		f.setVisible(true);
		
	}

}
