package Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import Model.Zone;

public class ListenerZone implements MouseListener {

	private AppGestionBorne c;
	private Zone m;
	
	public ListenerZone(AppGestionBorne c, Zone m) {
	this.c = c;
	this.m=m;
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel l = (JLabel) e.getSource();
		for(Component la : l.getParent().getComponents()){
			la.setForeground(Color.BLACK);
		}
		l.setForeground(Color.RED);
		c.selectedZone(m);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}