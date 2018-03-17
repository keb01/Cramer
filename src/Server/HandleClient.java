package Server;

import Controller.ListenerMagasin;
import Model.Borne;
import Model.BorneDAO;
import Model.Magasin;
import Model.MagasinDAO;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HandleClient implements Runnable,AppProtocol{
	private final Socket s;
	private InputManager in;
	private OutputManager out;
	private boolean stop = false;
	// private logger Terence
	
	
	public HandleClient(Socket s /*, logger Terence*/) throws IOException {
		this.s = s;
		//this.logger = logger;
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
			
			// logger Terence : client deconnecte
		}
	}

    @Override
    public void askListMagasin() throws IOException {
        MagasinDAO magasinDAO = new MagasinDAO();
        ArrayList<Magasin> listeMag = new ArrayList<Magasin>();
        listeMag = magasinDAO.getAllMagasins();

        /**** JSON CONCAT ****/
        ObjectMapper mapper = new ObjectMapper();
        String json = "[";
        for(Magasin m : listeMag){
            json += mapper.writeValueAsString(m)+",";
        }
        json += json.substring(0, json.length() - 1);
        json += "]";
        out.sendListMagasin(json);
    }
    
	@Override
	public void askListBornes() throws IOException {
		BorneDAO borneDAO = new BorneDAO();
		ArrayList<Borne> listeBorne = new ArrayList<Borne>();
		listeBorne = borneDAO.getAllBornes();
		/**** JSON CONCAT ****/
        ObjectMapper mapper = new ObjectMapper();
        String json = "[";
        for(Borne b : listeBorne){
            json += mapper.writeValueAsString(b)+",";
        }
        json += json.substring(0, json.length() - 1);
        json += "]";
        out.sendListMagasin(json);
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
