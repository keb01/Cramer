package client.view;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ItemList extends JPanel{
	public JLabel text;

	public ItemList(String txt){
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		text = new JLabel(txt);
		Border border = text.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		text.setBorder(new CompoundBorder(border, margin));
		this.add(text,BorderLayout.WEST);
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
	}
	
	public String getText(){
		return text.getText();
	}
	
	public void setColorText(Color c){
		text.setForeground(c);
	}
	
}
