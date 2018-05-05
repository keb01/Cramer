package server.serverApp;

import java.io.IOException;

import common.Borne;
import common.Personne;
import common.Profil;
import common.Vente;
import common.Zone;

public interface AppProtocol {


    // QUERIES
	//-------------------------------------------------------list--------------------------------------------------------\\
    public void askListMagasin() throws IOException;
    public void askListBornes() throws IOException;
    public void askListZones() throws IOException;
    public void askListVentesClientX(long id) throws IOException;
    public void askAllClient() throws IOException;   
    public void askAllProfils() throws IOException;   
    public void askMagasinProfil(Profil p) throws IOException;   
    
    //-------------------------------------------------------find--------------------------------------------------------\\
    public void askZone(long id) throws IOException;
    public void askBorne(long id) throws IOException;
    public void askProfil(long id) throws IOException;
    public void askPersonne(long id) throws IOException;
    public void askVente(long id) throws IOException;
    public void askCategorieMagasinVenteX(long id) throws IOException;
    
    //-------------------------------------------------------delete--------------------------------------------------------\\
    public void delZone(long id) throws IOException;
    public void delBorne(long id) throws IOException;
    public void delProfil(long id) throws IOException;
    public void delPersonne(long id) throws IOException;
    public void delVente(long id) throws IOException;
    
    //-------------------------------------------------------insert--------------------------------------------------------\\
    public void createZone(Zone zone) throws IOException;
    public void createBorne(Borne borne)throws IOException;
    public void createProfil(Profil profil)throws IOException;
    public void createPersonne(Personne personne)throws IOException;
    public void createVente(Vente vente)throws IOException;
    
    //-------------------------------------------------------update--------------------------------------------------------\\
    public void updateZone(Zone zone) throws IOException;
    public void updateBorne(Borne borne) throws IOException;
    public void updateProfil(Profil profil) throws IOException;
    public void updatePersonne(Personne personne) throws IOException;
    public void updatePersonneProfil(Personne personne) throws IOException;
    public void updateVente(Vente vente) throws IOException;    

    //-------------------------------------------------------Answers List--------------------------------------------------------\\
    public void sendListZones(String s);
    public void sendListBornes(String s);
    public void sendListMagasin(String s) throws IOException;
    public void sendListVentesClientX(String s) throws IOException;
    public void sendAllClients(String s) throws IOException; 
    public void sendAllProfils(String s) throws IOException; 
    public void sendMagasinProfil(String s) throws IOException;  
    
}
