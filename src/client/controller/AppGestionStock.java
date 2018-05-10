package client.controller;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import client.dtoClient.ClientAchatDTO;
import client.dtoClient.ClientArticleDTO;
import client.dtoClient.ClientFournisseurDTO;
import client.dtoClient.ClientMagasinDAO;
import client.dtoClient.ClientPersonneDAO;
import client.dtoClient.ClientStockMagasinDTO;
import client.dtoClient.Query;
import client.view.PanelListe;
import common.Achat;
import common.AchatDetail;
import common.Article;
import common.Fournisseur;
import common.Magasin;
import common.Personne;
import common.StockMagasin;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class AppGestionStock {
	private ClientFournisseurDTO fournisseurDTO;
	private ClientAchatDTO achatDTO;
	private ClientArticleDTO articleDTO;
	private ClientMagasinDAO magasinDTO;
	private ClientStockMagasinDTO stockMagasinDTO;
	private ClientPersonneDAO personneDTO;

	private JPanel tabPanel;
	private JPanel panelCreerAchat;
	private JList panelListeAchat;
	private JList panelListeMagasin;

	private JPanel panelDetail;
	private ArrayList<Achat> listeAchats;
	private ArrayList<Magasin> listeMagasins;
	private ArrayList<Fournisseur> listeFournisseurs;
	private JComboBox<Personne> employes;
	private JComboBox<Fournisseur> selectFournisseur;
	private JSpinner total;

	private Achat achatCourant;
	private Magasin magasinCourant;

	private JLabel achatBordereau;
	private JPanel panelAjoutDetail;
	private JComboBox<Article> detailArticle;
	private JSpinner detailQuantite;
	private JButton detailAjout;
	private PanelListe detailsListe;

	private JButton achatRecu;
	private JButton achatAnnule;
	private JPanel boutonsRecuAnnule;

	private JTabbedPane achatsEtMagasins;

	public AppGestionStock(JPanel tabPanel, Query q) {

		// Tab panel initialization
		this.tabPanel = tabPanel;
		this.tabPanel.setLayout(new BorderLayout());
		panelListeAchat = new JList<>();
		panelListeMagasin = new JList<>();
		panelCreerAchat = new JPanel();
		panelDetail = new PanelListe();
		tabPanel.add(panelCreerAchat, BorderLayout.NORTH);

		achatsEtMagasins = new JTabbedPane();
		achatsEtMagasins.add("Commandes", new JScrollPane(panelListeAchat));
		achatsEtMagasins.add("Magasins", new JScrollPane(panelListeMagasin));
		tabPanel.add(achatsEtMagasins, BorderLayout.WEST);
		tabPanel.add(panelDetail, BorderLayout.CENTER);

		// DAOs initialization
		this.listeAchats = new ArrayList<>();
		this.listeMagasins = new ArrayList<>();

		this.fournisseurDTO = new ClientFournisseurDTO(q);
		this.achatDTO = new ClientAchatDTO(q);
		this.articleDTO = new ClientArticleDTO(q);
		this.magasinDTO = new ClientMagasinDAO(q);
		this.stockMagasinDTO = new ClientStockMagasinDTO(q);
		this.personneDTO = new ClientPersonneDAO(q);

		// Stores list initialization
		listeFournisseurs = fournisseurDTO.getAllFournisseurs();

		String[] fournisseursSiret = new String[listeFournisseurs.size()];
		for (int i = 0; i < fournisseursSiret.length; i++)
			fournisseursSiret[i] = listeFournisseurs.get(i).siret;

		panelCreerAchat.setLayout(new GridLayout(1, 3));
		
		
		ArrayList<Personne> listeEmployes = personneDTO.getAllEmployes();
		employes = new JComboBox<>(listeEmployes.toArray(new Personne[listeEmployes.size()]));
		selectFournisseur = new JComboBox<>(listeFournisseurs.toArray(new Fournisseur[listeFournisseurs.size()]));
		panelCreerAchat.add(employes);
		panelCreerAchat.add(new JLabel("Fournisseur: "));
		panelCreerAchat.add(selectFournisseur);

		panelCreerAchat.add(new JLabel("Total: "));
		total = new JSpinner();
		panelCreerAchat.add(total);

		JButton creer = new JButton("Passer une commande");
		panelCreerAchat.add(creer);
		creer.addActionListener(new ListenerCreerAchat(this));

		// creer.addActionListener(new );
		updateListeAchats();
		updateListeMagasins();

		panelListeAchat.addListSelectionListener(new ListenerAchatSelection(this));
		panelListeMagasin.addListSelectionListener(new ListenerMagasinSelection(this));

		panelAjoutDetail = new JPanel();
		panelAjoutDetail.setLayout(new GridLayout());
		detailArticle = new JComboBox<>();
		detailQuantite = new JSpinner();
		detailAjout = new JButton("Ajouter");
		detailsListe = new PanelListe();
		panelAjoutDetail.add(detailArticle);
		panelAjoutDetail.add(detailQuantite);
		panelAjoutDetail.add(detailAjout);
		achatBordereau = new JLabel();

		detailAjout.addActionListener(new ListenerAjoutDetail(this));

		achatRecu = new JButton("Recu");
		achatAnnule = new JButton("Annuler");
		boutonsRecuAnnule = new JPanel();
		boutonsRecuAnnule.setLayout(new FlowLayout());
		boutonsRecuAnnule.add(achatRecu);
		boutonsRecuAnnule.add(achatAnnule);

		achatRecu.addActionListener((a) -> achatRecu());
		achatAnnule.addActionListener((a) -> achatAnnule());

	}

	public void updateListeFournisseurs() {
		listeFournisseurs = fournisseurDTO.getAllFournisseurs();
		selectFournisseur.removeAllItems();
		for (Fournisseur f : listeFournisseurs)
			selectFournisseur.addItem(f);

		/*
		 * String[] fournisseursSiret = new String[listeFournisseurs.size()];
		 * for ( int i = 0; i < fournisseursSiret.length; i++ )
		 * fournisseursSiret[i] = listeFournisseurs.get(i).siret;
		 */
	}

	public void updateListeAchats() {
		listeAchats = achatDTO.getAllAchats();
		panelListeAchat.removeAll();

		DefaultListModel<Achat> m = new DefaultListModel<>();
		for (Achat a : listeAchats) {
			m.addElement(a);
			// aPanel.addMouseListener();

		}
		panelListeAchat.setModel(m);

	}

	public void creerAchat() {
		Achat a = new Achat();

		Fournisseur f = (Fournisseur) selectFournisseur.getSelectedItem();
		a.idEmploye = ((Personne)employes.getSelectedItem()).getId();
		a.idFournisseur = f.id;
		a.total = Integer.parseInt(total.getValue().toString());

		achatDTO.create(a);
		updateListeAchats();
	}

	public void montrerAchat(Achat a) {
		if ( a == null ) return;
		achatCourant = a;
		panelDetail.removeAll();

		achatBordereau.setText("statut: " + Achat.statutText(a.statut) + " / le: " + a.dateAchat + " / total: " + a.total);
		panelDetail.add(achatBordereau);

		if (a.statut == Achat.STATUT_COMMANDE) {
			panelDetail.add(boutonsRecuAnnule);
			panelDetail.add(panelAjoutDetail);
		}

		panelDetail.add(detailsListe);

		HashMap<Long, Article> articlesByID = new HashMap<>();

		ArrayList<Article> articles = articleDTO.getAllArticles(a.idFournisseur);
		detailArticle.removeAllItems();
		for (Article article : articles) {
			detailArticle.addItem(article);
			articlesByID.put(article.getId(), article);
		}

		detailsListe.removeAll();
		ArrayList<AchatDetail> details = achatDTO.getAchatDetails(a.id);
		for (AchatDetail ad : details)
			detailsListe.add(new JLabel(articlesByID.get(ad.idArticle) + ": " + ad.quantite));

		panelDetail.revalidate();
		panelDetail.repaint();

	}

	public void ajouterDetail() {
		AchatDetail detail = new AchatDetail();
		detail.idAchat = achatCourant.id;
		detail.idArticle = ((Article) detailArticle.getSelectedItem()).getId();
		detail.quantite = (Integer) detailQuantite.getValue();

		achatDTO.ajouterAchatDetail(detail);
		montrerAchat(achatCourant);
	}

	public void achatRecu() {
		achatCourant.statut = 1;
		achatDTO.changerAchatStatut(achatCourant);
		montrerAchat(achatCourant);
		updateListeAchats();
	}

	public void achatAnnule() {
		achatCourant.statut = 2;
		achatDTO.changerAchatStatut(achatCourant);
		montrerAchat(achatCourant);
		updateListeAchats();
	}

	private void updateListeMagasins() {
		listeMagasins = magasinDTO.getAllMagasins();
		panelListeMagasin.removeAll();

		DefaultListModel<Magasin> m = new DefaultListModel<>();
		for (Magasin a : listeMagasins) {
			m.addElement(a);
			// aPanel.addMouseListener();

		}
		panelListeMagasin.setModel(m);
	}

	public void montrerMagasin(Magasin magasin) {
		magasinCourant = magasin;
		panelDetail.removeAll();

		ArrayList<Article> list = articleDTO.getAllArticlesOfMagasin(magasin.getId());
		HashMap<Long, String> namesById = new HashMap<>();
		for ( Article a : list )
			namesById.put(a.getId(), a.getNom());
		System.out.println(namesById);
		
		JPanel liste = new PanelListe();
		ArrayList<StockMagasin> stocks = stockMagasinDTO.getAllStocks(magasin.getId());
		for (StockMagasin s : stocks) {
			if (s.quantite == 0)
				continue;

			JPanel article = new JPanel();

			JButton vendre = new JButton("Vendre");
			vendre.addActionListener((a) -> vendre(s.idArticle, s.quantite - 1));
			article.add(vendre);
			article.add(new JLabel(namesById.get(s.idArticle) + " (stock:" + s.quantite + ")"));

			liste.add(article);
		}

		panelDetail.add(liste);
		panelDetail.revalidate();
		panelDetail.repaint();
	}

	public void vendre(long idArticle, int nouvelleQuantite) {
		stockMagasinDTO.modifier(magasinCourant.getId(), idArticle, nouvelleQuantite);
		montrerMagasin(magasinCourant);
	}
}
