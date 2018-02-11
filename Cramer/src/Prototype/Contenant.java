package Prototype;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Contenant extends JPanel{

	public Contenant() {
		GridLayout gl = new GridLayout(0,3);
		gl.setHgap(20); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		gl.setVgap(10);
		//FlowLayout = new FlowLayout();
		this.setLayout(gl);
	}

}
