package client.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import client.view.ItemList;
import common.Magasin;

public class ListenerMagasinBis implements MouseListener {
	
	private AppGestionRedevance c;
	private Magasin m;
	
	public ListenerMagasinBis(AppGestionRedevance c, Magasin m) {
	this.c = c;
	this.m=m;
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ItemList l = (ItemList) e.getSource();
		for(Component la : l.getParent().getComponents()){
			ItemList item = (ItemList) la;
			item.setBackground(Color.WHITE);
			item.setColorText(Color.BLACK);
		}
		l.setBackground(Color.GRAY);
		l.setColorText(Color.WHITE);
		c.selectedMagasin(m);
		
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
