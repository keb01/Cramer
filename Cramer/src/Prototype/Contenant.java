package Prototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Contenant extends JPanel {
	private JPanel contenant, containerArticle;
	private PanelListe p1,p2;
	
	public Contenant() {
		this.setSize(1000,600);
		this.setBorder(new LineBorder(Color.BLUE));
		this.setLayout(new BorderLayout());
		//contenant = new JPanel();
		p1 = new PanelListe();
		
		p1.setBorder(new LineBorder(Color.GREEN));
		p2 = new PanelListe();
		p2.setSize(300,600);
		p2.setBorder(new LineBorder(Color.GREEN));
		containerArticle = new JPanel();
		containerArticle.setPreferredSize(new Dimension(400, 600));
		containerArticle.setBorder(new LineBorder(Color.GREEN));
		
		this.add(p1,BorderLayout.WEST);

		JScrollPane scroll = new JScrollPane(p1);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll,BorderLayout.WEST);
		this.add(p2,BorderLayout.CENTER);
		this.add(containerArticle,BorderLayout.EAST);
	}

	public JPanel getContenant() {
		return contenant;
	}

	public void setContenant(JPanel contenant) {
		this.contenant = contenant;
	}

	public JPanel getContainerArticle() {
		return containerArticle;
	}

	public void setContainerArticle(JPanel containerArticle) {
		this.containerArticle = containerArticle;
	}

	public PanelListe getP1() {
		return p1;
	}

	public void setP1(PanelListe p1) {
		this.p1 = p1;
	}

	public PanelListe getP2() {
		return p2;
	}

	public void setP2(PanelListe p2) {
		this.p2 = p2;
	}
	
	

}
