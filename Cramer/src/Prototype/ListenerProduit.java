package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerProduit implements ActionListener{

	private Produit prod;
	public ListenerProduit(Produit prod) {
	this.prod=prod;	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		prod.chargerInfos();
		FICHIERNAWEL.afficherDetailProd(prod);
	}

}
