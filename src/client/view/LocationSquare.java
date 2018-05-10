package client.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LocationSquare extends JPanel {
	private Long id;
	private Color c;
	
	
	public LocationSquare(Long id, Color c){
		this.id = id;
		this.c = c;
		this.setBackground(c);
		this.setBorder(new LineBorder(Color.GRAY));
		this.add(new JLabel(Long.toString(id)));
	}

	
	public void updateColor(Color c){
		this.c = c;
		this.setBackground(c);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Color getC() {
		return c;
	}


	public void setC(Color c) {
		this.c = c;
	}
	
	
}
