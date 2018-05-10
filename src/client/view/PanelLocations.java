package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelLocations extends JPanel{
	private ArrayList<LocationSquare> locations;
	private JPanel impair,pair;
	
	
	public PanelLocations(){
		locations = new ArrayList<>();
		
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(1000,150));
		this.setBorder(new LineBorder(Color.GRAY));
		this.setVisible(true);

		
		impair = new JPanel();
		impair.setLayout(new FlowLayout());
		pair = new JPanel();
		pair.setLayout(new FlowLayout());
		
		this.add(pair);
		this.add(impair);
		

		
	}
	
	public void setLocationFull(Long id,String txt){
		for(LocationSquare ls : locations){
			if(ls.getId() == id){
				ls.updateColor(Color.GREEN);
				ls.setToolTipText(txt);
			}
		}
	}
	
	public void setLocationEmpty(Long id){
		for(LocationSquare ls : locations){
			if(ls.getId() == id){
				ls.updateColor(Color.GRAY);
			}
		}
	}
	
	public void addLocation(Long id){
		LocationSquare loc = new LocationSquare(id, Color.GREEN);
		locations.add(loc);
		if((id%2)==0){
			pair.add(loc);
		}else{
			impair.add(loc);
		}
	}
	

	
}
