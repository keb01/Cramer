package common;

import java.util.Date;

import server.model.RedevanceDAO;

public class Redevance {

    /**
     * id of the fee
     */
    private int id_redevance;
    /**
     * id of the store
     */
    private Magasin id_magasin;
    private String nom_magasin;
    /**
     * amount
     */
    private float montant_redevance;
    /**
     * date of the payment
     */
    private Date date_redevance;
    /**
     * Constructor
     */
    public Redevance() {
    }
    /**
     * Constructor
     * @param id_redevance id
     * @param id_magasin store id
     * @param date_redevance date
     * @param montant_redevance amount
     */
    public Redevance(int id_redevance, Magasin id_magasin, String nom_magasin, float montant_redevance, Date date_redevance) {
        this.id_redevance = id_redevance;
        this.id_magasin = id_magasin;
        this.nom_magasin = id_magasin.getNom();
        this.montant_redevance = montant_redevance;
        this.date_redevance = date_redevance;
    }
    
    public Redevance(int id_redevance, Magasin id_magasin, String nom_magasin, Date date_redevance) {
        this.id_redevance = id_redevance;
        this.id_magasin = id_magasin;
        this.nom_magasin = id_magasin.getNom();
        this.montant_redevance = calculR(id_magasin.getId());
        this.date_redevance = date_redevance;
    }

    /**
     * get the fee id
     * @return the id
     */
    public int getid_Redevance() {
        return this.id_redevance;
    }
    /**
     * set the fee id
     * @param id_redevance the new id
     */
    public void setid_Redevance(int id_redevance) {
        this.id_redevance = id_redevance;
    }
    /**
     * get the store id
     * @return the store id
     */
    public Magasin getId_magasin() {
        return this.id_magasin;
    }
    /**
     * set the store id
     * @param id_magasin the new store id
     */
    public void setId_magasin(Magasin id_magasin) {
        this.id_magasin = id_magasin;
    }
    public String getNom_magasin() {
        return this.nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }
    /**
     * get the date
     * @return the date
     */
    public Date getDate_redevance() {
        return this.date_redevance;
    }
    /**
     * set the date
     * @param date_redevance the new date
     */
    public void setDate_redevance(Date date_redevance) {
        this.date_redevance = date_redevance;
    }
    /**
     * get the fee
     * @return the fee
     */
    public float getMontant_redevance() {
        return this.montant_redevance;
    }
    /**
     * set the fee
     * @param montant_redevance of the new fee
     */
    public void setMontant_redevance(float montant_redevance) {
        this.montant_redevance = montant_redevance;
    }

    /**
     * method to display a fee
     * @return the display
     */
    public String toString() {
        return "Magasin: "+this.nom_magasin + "   MONTANT:" + this.montant_redevance+"\u20AC";
    }
    
    public String toStringBis(long id) {
    	RedevanceDAO redevanceDAO = new RedevanceDAO();
    	return redevanceDAO.afficheF(id);
    }
    
    public float  calculR (long id) {
    	RedevanceDAO redevanceDAO = new RedevanceDAO();
    	return redevanceDAO.calculR(id);
    	
    	
    }

   
}

