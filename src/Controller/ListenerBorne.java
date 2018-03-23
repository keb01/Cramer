package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
