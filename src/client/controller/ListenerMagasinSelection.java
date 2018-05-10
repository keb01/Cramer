package client.controller;

import common.Achat;
import common.Magasin;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ListenerMagasinSelection implements ListSelectionListener {
  
  private AppGestionStock c;
  
  public ListenerMagasinSelection(AppGestionStock c) {
    this.c = c;
  }
  
  @Override
  public void valueChanged(ListSelectionEvent e) {
    JList<Magasin> list = (JList<Magasin>) e.getSource();
    
    c.montrerMagasin(list.getSelectedValue());
  }
}

