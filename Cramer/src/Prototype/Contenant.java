package Prototype;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Contenant extends JPanel{

	public Contenant() {
		GridLayout gl = new GridLayout(0,2);
		gl.setHgap(20); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		gl.setVgap(10);
		this.setLayout(gl);
	}

}