package client.controller;

import common.Achat;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ListenerAchatSelection implements ListSelectionListener {
  
  private AppGestionStock c;
  
  public ListenerAchatSelection(AppGestionStock c) {
    this.c = c;
  }
  
  @Override
  public void valueChanged(ListSelectionEvent e) {
    JList<Achat> list = (JList<Achat>) e.getSource();
    c.montrerAchat(list.getSelectedValue());
  }
}
