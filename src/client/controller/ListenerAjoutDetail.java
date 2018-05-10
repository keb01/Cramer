package client.controller;

import common.Achat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAjoutDetail implements ActionListener {
  private AppGestionStock c;
  
  public ListenerAjoutDetail(AppGestionStock c) {
    this.c = c;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    c.ajouterDetail();
  }
}

