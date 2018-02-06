package Prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerMagasin implements ActionListener {

	private Magasin mag;
	public ListenerMagasin(Magasin mag) {
	this.mag=mag;	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//mag.chargerProduit();
		//FICHIERNAWEL.afficherProduit(Magasin);
	}

}
