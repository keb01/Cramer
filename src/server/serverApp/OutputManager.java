package server.serverApp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

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

public class OutputManager implements AppProtocol{
	PrintWriter ow;
	
	
	public OutputManager(OutputStream out) throws IOException {
		this.ow = new PrintWriter(out, true);
	}

	//-------------------------------------------------------list--------------------------------------------------------\\
	@Override
	public void askListEmplacement() throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
    public void askListAchats() throws IOException {

    }
    
    @Override
    public void askListMagasin() throws IOException {

    }
	
    @Override
	public void askListBornes() throws IOException {
		
	}

	@Override
	public void askListZones() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void askListVentesClientX(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void askAllProfils() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askMagasinProfil(Profil p) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askAllMagasins() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
    @Override
	public void askAllClient() throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    @Override
	public void askAllRedevances() throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    @Override
	public void askEmptyListEmplacement() throws IOException {
		// TODO Auto-generated method stub
		
	}

	//-------------------------------------------------------find--------------------------------------------------------\\
	@Override
	public void askEmplacement(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
    @Override
	public void askZone(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    @Override
	public void askBorne(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    @Override
	public void askProfil(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askPersonne(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void askVente(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askCategorieMagasinVenteX(long id) throws IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void askMagasin(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void askRedevance(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void askProfilVente(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	// -------------------------------------------------------delete--------------------------------------------------------\\
	@Override
	public void delEmplacement(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delZone(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delBorne(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delProfil(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delPersonne(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delVente(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delRedevance(int id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	// -------------------------------------------------------insert--------------------------------------------------------\\
	@Override
	public void createZone(Zone zone) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBorne(Borne borne) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createProfil(Profil profil) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPersonne(Personne personne) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createVente(Vente vente) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createEmplacement(Emplacement emp) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createAchat(Achat achat) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createRedevance(Redevance redevance) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createMagasin(Magasin magasin) throws IOException {
		// TODO Auto-generated method stub
		
	}

	// -------------------------------------------------------update--------------------------------------------------------\\
	@Override
	public void updateZone(Zone zone) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBorne(Borne borne) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfil(Profil profil) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePersonne(Personne personne) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updatePersonneProfil(Personne personne) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVente(Vente vente) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateEmplacement(Emplacement emp) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateRedevance(Redevance redevance) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	// -------------------------------------------------------answer list--------------------------------------------------------\\
	public void sendList(String s) {
		ow.println(s);
	}
	
	

	@Override
	public void sendListZones(String s) {
		ow.println(s);
	}

	@Override
	public void sendListBornes(String s) {
		ow.println(s);
        //System.out.println(s);
	}

	@Override
	public void sendListMagasin(String s) {
		ow.println(s);
        //System.out.println(s);
	}

	@Override
	public void sendListVentesClientX(String s) throws IOException {
		ow.println(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendAllClients(String s) throws IOException {
		ow.println(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendAllProfils(String s) throws IOException {
		ow.println(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMagasinProfil(String s) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendAllMagasins(String s) throws IOException {
		ow.println(s);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void sendProfilVente(String s) throws IOException {
		ow.println(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askListFournisseurs() throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sendAllEmplacements(String s) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void sendAllRedevances(String s) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askListStockMagasin(long idMagasin) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askListAchatDetails(long idAchat) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askListArticles(long idfournisseur) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAchatDetail(AchatDetail achatDetail) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStockQuantite(StockMagasin stock) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAchatStatut(Achat achat) throws IOException {
		// TODO Auto-generated method stub
		
	}

	// IMPLEMENT METHODS OF PROTOCOL FOR SENDING JSON TO CLIENT
	
	
}
