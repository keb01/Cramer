package server.serverApp;

import java.io.IOException;

import common.Achat;
import common.AchatDetail;
import common.Borne;
import common.Emplacement;
import common.Magasin;
import common.Personne;
import common.Profil;
import common.Vente;
import common.Zone;
import common.Redevance;
import common.StockMagasin;

public interface AppProtocol {


    // QUERIES
	//-------------------------------------------------------list--------------------------------------------------------\\

	public void askListStockMagasin(long idMagasin) throws IOException;
	public void askListAchatDetails(long idAchat) throws IOException;
	public void askListArticles(long idfournisseur) throws IOException;
	public void askListMagasin() throws IOException;
    public void askListBornes() throws IOException;
    public void askListZones() throws IOException;
    public void askListVentesClientX(long id) throws IOException;
    public void askAllClient() throws IOException;   
    public void askAllProfils() throws IOException;
    public void askAllMagasins() throws IOException;      
    public void askMagasinProfil(Profil p) throws IOException;
	public void askListFournisseurs() throws IOException;
	public void askListAchats() throws IOException;
	public void askListEmplacement() throws IOException;
	public void askEmptyListEmplacement() throws IOException;
	public void askAllRedevances() throws IOException;
    
    //-------------------------------------------------------find--------------------------------------------------------\\
    public void askZone(long id) throws IOException;
    public void askBorne(long id) throws IOException;
    public void askProfil(long id) throws IOException;
    public void askPersonne(long id) throws IOException;
    public void askVente(long id) throws IOException;
    public void askMagasin(long id) throws IOException;
    public void askCategorieMagasinVenteX(long id) throws IOException;
    public void askEmplacement(long id) throws IOException;
    public void askRedevance(long id) throws IOException;  
    public void askProfilVente(long id)throws IOException;
    
    //-------------------------------------------------------delete--------------------------------------------------------\\
    public void delZone(long id) throws IOException;
    public void delBorne(long id) throws IOException;
    public void delProfil(long id) throws IOException;
    public void delPersonne(long id) throws IOException;
    public void delVente(long id) throws IOException;
    public void delEmplacement(long id) throws IOException;
    public void delRedevance(int id) throws IOException;

    
    //-------------------------------------------------------insert--------------------------------------------------------\\
    public void createAchatDetail(AchatDetail achatDetail) throws IOException;
    public void createZone(Zone zone) throws IOException;
    public void createBorne(Borne borne)throws IOException;
    public void createProfil(Profil profil)throws IOException;
    public void createPersonne(Personne personne)throws IOException;
    public void createVente(Vente vente)throws IOException;
    public void createAchat(Achat achat) throws IOException;
    public void createEmplacement(Emplacement emp) throws IOException;
    public void createMagasin(Magasin magasin)throws IOException;
    public void createRedevance(Redevance redevance)throws IOException;
    
    //-------------------------------------------------------update--------------------------------------------------------\\
    public void updateStockQuantite(StockMagasin stock) throws IOException;
    public void updateAchatStatut(Achat achat) throws IOException;
    public void updateZone(Zone zone) throws IOException;
    public void updateBorne(Borne borne) throws IOException;
    public void updateProfil(Profil profil) throws IOException;
    public void updatePersonne(Personne personne) throws IOException;
    public void updatePersonneProfil(Personne personne) throws IOException;
    public void updateVente(Vente vente) throws IOException;    
    public void updateEmplacement(Emplacement emp) throws IOException; 
    public void updateRedevance(Redevance redevance) throws IOException; 
    
    //-------------------------------------------------------Answers List--------------------------------------------------------\\
    public void sendListZones(String s);
    public void sendListBornes(String s);
    public void sendListMagasin(String s) throws IOException;
    public void sendListVentesClientX(String s) throws IOException;
    public void sendAllClients(String s) throws IOException; 
    public void sendAllProfils(String s) throws IOException;
    public void sendAllMagasins(String s) throws IOException;  
    public void sendMagasinProfil(String s) throws IOException;
    public void sendAllEmplacements(String s) throws IOException;
    public void sendAllRedevances(String s) throws IOException;
    
}
