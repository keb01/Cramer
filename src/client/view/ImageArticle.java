package client.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImageArticle extends JPanel{
	private Image imgArticle;
	
	public ImageArticle(String url){
		this.imgArticle = Toolkit.getDefaultToolkit().getImage(url);
		//this.setSize(400, 260);
		this.setPreferredSize(new Dimension(400, 260));
		//this.setMaximumSize(new Dimension(400, 260));
		this.setBackground(Color.BLACK);
	}
	
	@Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(imgArticle,0,0,this);
    }
	
	public void update(String url){
		this.imgArticle = Toolkit.getDefaultToolkit().getImage(url);
		repaint();
		revalidate();
	}
	
}
