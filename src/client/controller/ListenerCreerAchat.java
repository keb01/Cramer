package client.controller;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import common.Achat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class ListenerCreerAchat implements MouseListener, ActionListener{

	private AppGestionStock c;
	
	
	public ListenerCreerAchat(AppGestionStock c) {
		this.c = c;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		c.creerAchat();
	
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

  @Override
  public void actionPerformed(ActionEvent e)  {
    		  mouseClicked(null);

  }
	

}

