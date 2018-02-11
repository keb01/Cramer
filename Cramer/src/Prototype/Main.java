package Prototype;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Fenetre f = new Fenetre();
		Contenant p = new Contenant();
		PanelListe p1 = new PanelListe();
		PanelListe p2 = new PanelListe();
		
		MagasinDAO dao = new MagasinDAO();
		ArrayList<Magasin> listeMagasins = new ArrayList<Magasin>();
		
		listeMagasins = dao.getAllMagasins();
		
		for(Magasin m : listeMagasins  ) {
			//dao.getListeProduit(m);
			PanelListeObjet panel = new PanelListeObjet(m);
			panel.addMouseListener(new ListenerMagasin(panel,p2,p,f));
			p1.add(panel);
		}
		
		p.add(p1);
		f.add(p);
		JScrollPane scroll = new JScrollPane(p1);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		f.getContentPane().add(scroll, BorderLayout.WEST);
		f.setVisible(true);
	}

}
