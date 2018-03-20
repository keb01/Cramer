package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Magasin;
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