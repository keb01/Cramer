package Prototype;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
	MagasinDAO DAOp = new MagasinDAO();
	//Magasin p1 = DAOp.find(1);
	ArrayList<Magasin> lm= new ArrayList<Magasin>();
	
	for(Magasin m : DAOp.getAllMagasins()){
		lm.add(m);
	}
	
	DAOp.getListeProduit(lm.get(0));
	
	for( Produit p : lm.get(0).getListeProduits() ){
		System.out.println(p.getNom());

	}
	
	
		}
}
