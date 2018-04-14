package Server;


import Model.Borne;
import Model.BorneDAO;
import Model.Magasin;
import Model.MagasinDAO;
import Model.Personne;
import Model.PersonneDAO;
import Model.Profil;
import Model.ProfilDAO;
import Model.Zone;
import Model.ZoneDAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;

public class HandleClient implements Runnable,AppProtocol{
	private final Socket s;
	private InputManager in;
	private OutputManager out;
	private boolean stop = false;
	private LoggerWriter logger;
	private Connection c;
	
	
	public HandleClient(Socket s, LoggerWriter logger, Connection c ) throws IOException {
		this.s = s;
		this.logger = logger;
		this.c = c;
	}
	
	public void run() {
		try (Socket s1 = s) {
			out = new OutputManager(s1.getOutputStream());
			in = new InputManager(s1.getInputStream(), this);
			in.doRun();
		} catch (IOException | JSONException ex) {
			if (!stop) {
				finish();
			}
		}
		finally
		{
			ServerCore.pool.releaseConnection(c);
		}
	}
	
	public synchronized void finish(){
		if (!stop) {
			stop = true;
			try {
				s.close();
			} catch (IOException ex) { ex.printStackTrace(); }
			
			this.logger.setMessageLog("Client exit");
		}
	}

	//-------------------------------------------------------list--------------------------------------------------------\\
	
    @Override
    public void askListMagasin() throws IOException {
        MagasinDAO magasinDAO = new MagasinDAO();
        magasinDAO.setConnection(c);
        ArrayList<Magasin> listeMag = new ArrayList<Magasin>();
        listeMag = magasinDAO.getAllMagasins();
        /**** JSON MAPPER ****/
        ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listeMag);
		out.sendListMagasin(json);
    }
    
	@Override
	public void askListBornes() throws IOException {
		BorneDAO borneDAO = new BorneDAO();
		borneDAO.setConnection(c);
		ArrayList<Borne> listeBorne = new ArrayList<Borne>();
		listeBorne = borneDAO.getAllBornes();
		/**** JSON MAPPER ****/
        ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listeBorne);
        out.sendListMagasin(json);
	}
	
	@Override
	public void askListZones() throws IOException {
		ZoneDAO zoneDAO = new ZoneDAO();
		zoneDAO.setConnection(c);
		ArrayList<Zone> listeZone = new ArrayList<Zone>();
		listeZone = zoneDAO.getAllZones();
		/**** JSON MAPPER ****/
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listeZone);
        out.sendListZones(json);
		
	}
	
	//-------------------------------------------------------find--------------------------------------------------------\\
	
	@Override
	public void askZone(long id) throws IOException {
		ZoneDAO zoneDAO = new ZoneDAO();
		zoneDAO.setConnection(c);
		Zone zone = new Zone();
		zone = zoneDAO.find(id);
		/**** JSON MAPPER ****/
		out.sendListBornes("ok");
		
	}
	
	    @Override
	public void askBorne(long id) throws IOException {
	    	BorneDAO borneDAO = new BorneDAO();
	    	borneDAO.setConnection(c);
			Borne borne = new Borne();
			borne = borneDAO.find(id);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
		
	}
	
	    @Override
	public void askProfil(long id) throws IOException {
	    	ProfilDAO profilDAO = new ProfilDAO();
	    	profilDAO.setConnection(c);
	    	Profil profil = new Profil();
			profil = profilDAO.find(id);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
		
	}
	    
	    @Override
		public void askPersonne(long id) throws IOException {
	    		PersonneDAO personneDAO = new PersonneDAO();
		    	personneDAO.setConnection(c);
		    	Personne personne = new Personne();
		    	personne = personneDAO.find(id);
				/**** JSON MAPPER ****/
				out.sendListBornes("ok");
			
		}

	  //-------------------------------------------------------delete--------------------------------------------------------\\
	    
	@Override
		public void delZone(long id) throws IOException {
			ZoneDAO zDAO = new ZoneDAO();
			zDAO.setConnection(c);
			Zone zone = new Zone(id, "", "", 0);
			zDAO.delete(zone);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");;
			
		}

		@Override
		public void delBorne(long id) throws IOException {
			BorneDAO borneDAO = new BorneDAO();
			borneDAO.setConnection(c);
			Borne borne = new Borne(id,new Zone());
			borneDAO.delete(borne);
			/**** JSON MAPPER ****/
	        out.sendListZones("ok");
			
		}
		
		@Override
		public void delProfil(long id) throws IOException {
			ProfilDAO profilDAO = new ProfilDAO();
			profilDAO.setConnection(c);
			Profil profil = new Profil(id,"");
			profilDAO.delete(profil);
			/**** JSON MAPPER ****/
	        out.sendListZones("ok");
			
		}
		
		@Override
		public void delPersonne(long id) throws IOException {
			PersonneDAO personneDAO = new PersonneDAO();
			personneDAO.setConnection(c);
			Personne personne = new Personne(id,"", null, 0, null, 0, null, 0);
			personneDAO.delete(personne);
			/**** JSON MAPPER ****/
	        out.sendListZones("ok");
			
		}

		//-------------------------------------------------------insert--------------------------------------------------------\\
		
		@Override
		public void createZone(Zone zone) throws IOException {
			ZoneDAO zDAO = new ZoneDAO();
			zDAO.setConnection(c);
			zone = 	zDAO.create(zone);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}

		@Override
		public void createBorne(Borne borne) throws IOException {
			BorneDAO borneDAO = new BorneDAO();
			borneDAO.setConnection(c);
			borne = borneDAO.create(borne);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}
		
		@Override
		public void createProfil(Profil profil) throws IOException {
			ProfilDAO profilDAO = new ProfilDAO();
			profilDAO.setConnection(c);
			profil = profilDAO.create(profil);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}
		
		@Override
		public void createPersonne(Personne personne) throws IOException {
			PersonneDAO personneDAO = new PersonneDAO();
			personneDAO.setConnection(c);
			personne = personneDAO.create(personne);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}

		//-------------------------------------------------------update--------------------------------------------------------\\
		
		@Override
		public void updateZone(Zone zone) throws IOException {
			ZoneDAO zDAO = new ZoneDAO();
			zDAO.setConnection(c);
			zone = zDAO.update(zone);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}

		@Override
		public void updateBorne(Borne borne) throws IOException {
			BorneDAO borneDAO = new BorneDAO();
			borneDAO.setConnection(c);
			borneDAO.update(borne);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}
		
		@Override
		public void updateProfil(Profil profil) throws IOException {
			ProfilDAO profilDao = new ProfilDAO();
			profilDao.setConnection(c);
			profilDao.update(profil);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}
		
		@Override
		public void updatePersonne(Personne personne) throws IOException {
			PersonneDAO personneDao = new PersonneDAO();
			personneDao.setConnection(c);
			personneDao.update(personne);
			/**** JSON MAPPER ****/
			out.sendListBornes("ok");
			
		}
		
		//-------------------------------------------------------list--------------------------------------------------------\\
		@Override
		public void sendListZones(String s) {

		}

		@Override
		public void sendListBornes(String s) {

		}

		@Override
		public void sendListMagasin(String s) throws IOException {
			
		}

	




	// IMPLEMENT METHODS OF PROTOCOL BY USING 'OUT'
	
	
}
