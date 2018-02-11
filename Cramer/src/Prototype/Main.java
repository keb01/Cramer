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
		f.setSize(800,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Contenant p = new Contenant();
		f.setLayout(new BorderLayout());
		JPanel containerArticle = new JPanel();
		containerArticle.setPreferredSize(new Dimension(400, 600));
		f.add(containerArticle,BorderLayout.EAST);
		PanelListe p1 = new PanelListe();
		PanelListe p2 = new PanelListe();
		
		MagasinDAO dao = new MagasinDAO();
		ArrayList<Magasin> listeMagasins = new ArrayList<Magasin>();
		
		listeMagasins = dao.getAllMagasins();
		
		for(Magasin m : listeMagasins  ) {
			//dao.getListeProduit(m);
			PanelListeObjet panel = new PanelListeObjet(m);
			panel.addMouseListener(new ListenerMagasin(panel,p2,p,f,containerArticle));
			p1.add(panel);
		}
		
		p.add(p1);
		
		JScrollPane scroll = new JScrollPane(p1);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		f.add(p);
		f.getContentPane().add(scroll, BorderLayout.WEST);
		f.setVisible(true);
		
	}

}
