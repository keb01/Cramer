package Prototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreModificationArticle extends JFrame {
	private JPanel container = new JPanel();
	private JTextField jtf1;
	private JLabel label1 = new JLabel("Nom : ");
	private PanelArticle panel;

	public FenetreModificationArticle(PanelArticle panel) {
		this.panel = panel;
		this.setTitle("Modification du Produit");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		Font police = new Font("Arial", Font.BOLD, 14);
		jtf1 = new JTextField(panel.getProduit().getNom());
		jtf1.setFont(police);
		jtf1.setPreferredSize(new Dimension(150, 30));
		jtf1.setForeground(Color.BLUE);
		top.add(label1);
		top.add(jtf1);
		container.add(top, BorderLayout.NORTH);
		JButton enregistrer = new JButton("Enregistrer");
		container.add(enregistrer, BorderLayout.SOUTH);
		enregistrer.addActionListener(new ListenerRecArticle(this));
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	


	public JTextField getJtf1() {
		return jtf1;
	}

	public void modifierArticle() {
		panel.modifierArticle(jtf1.getText());
		setVisible(false);
		dispose();
	}
}