package Prototype;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Application {
	public static void main(String[] args) {
	MagasinDAO DAOp = new MagasinDAO();
	//Magasin p1 = DAOp.find(1);
	ArrayList<Magasin> lm= new ArrayList<Magasin>();
	
	for(Magasin m : DAOp.getAllMagasins()){
		lm.add(m);
	}
	
	DAOp.getListeProduit(lm.get(0));
	
	Produit p = lm.get(0).getListeProduits().get(0); 
	
		System.out.println(p.getNom());
		JFrame f = new JFrame(p.getNom());
		f.add(new PanelArticle(p));
		
		f.setVisible(true);

	
	
		}
}
