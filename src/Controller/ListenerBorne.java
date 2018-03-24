package Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import Model.Borne;

public class ListenerBorne implements MouseListener{

	private AppGestionBorne c;
	private Borne p;
	
	
	public ListenerBorne(AppGestionBorne c,Borne p) {
		this.c = c;
		this.p=p;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel l = (JLabel) arg0.getSource();
		for(Component la : l.getParent().getComponents()){
			la.setForeground(Color.BLACK);
		}
		l.setForeground(Color.RED);
	c.selectedBorne(p);
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
