package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AppGestionBorne;

public class AddBorneWindow extends JFrame{
	private JPanel container = new JPanel();
	private JComboBox<String> comboZone;
	private JLabel label1 = new JLabel("Zone : ");
	private JButton enregistrer;

	public AddBorneWindow(AppGestionBorne a, String[] listZone) {
		this.setTitle("Ajout d'une borne");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		Font police = new Font("Arial", Font.BOLD, 14);
		comboZone = new JComboBox<String>();
		comboZone.setModel(new DefaultComboBoxModel<String>(listZone));
		top.add(label1);
		top.add(comboZone);
		container.add(top, BorderLayout.NORTH);
		enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				a.addBorne(comboZone.getSelectedItem().toString());
				
			}
		});
		container.add(enregistrer, BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(false);
	}
	
}
