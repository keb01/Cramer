package Server;


import Model.Borne;
import Model.BorneDAO;
import Model.Magasin;
import Model.MagasinDAO;
import Model.Zone;
import Model.ZoneDAO;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HandleClient implements Runnable,AppProtocol{
	private final Socket s;
	private InputManager in;
	private OutputManager out;
	private boolean stop = false;
	private LoggerWriter logger;
	
	
	public HandleClient(Socket s ,LoggerWriter logger ) throws IOException {
		this.s = s;
		this.logger = logger;
	}
	
	public void run() {
		try (Socket s1 = s) {
			out = new OutputManager(s1.getOutputStream());
			in = new InputManager(s1.getInputStream(), this);
			in.doRun();
		} catch (IOException ex) {
			if (!stop) {
				finish();
			}
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

    @Override
    public void askListMagasin() throws IOException {
        MagasinDAO magasinDAO = new MagasinDAO();
        ArrayList<Magasin> listeMag = new ArrayList<Magasin>();
        listeMag = magasinDAO.getAllMagasins();
        /**** JSON MAPPER ****/
        ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listeMag);
		//out.sendListMagasin(json);
    }
    
	@Override
	public void askListBornes() throws IOException {
		BorneDAO borneDAO = new BorneDAO();
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
		ArrayList<Zone> listeZone = new ArrayList<Zone>();
		listeZone = zoneDAO.getAllZones();
		/**** JSON MAPPER ****/
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listeZone);
        out.sendListZones(json);
		
	}
	
	public void askZone(long id) throws IOException {
		ZoneDAO zoneDAO = new ZoneDAO();
		Zone listeZone = new Zone();
		listeZone = zoneDAO.find(id);
		/**** JSON MAPPER ****/
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listeZone);
        out.sendListZones(json);
		
	}

    @Override
	public void sendListZones(String s) {

	}

	@Override
	public void sendListBornes(String s) {

	}

	@Override
	public void sendListMagasin(String s) throws IOException {}

	




	// IMPLEMENT METHODES DU PROTOCOL EN UTILISANT NOTRE 'OUT'
	
	
}
