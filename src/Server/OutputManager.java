package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import Model.Borne;
import Model.Zone;

public class OutputManager implements AppProtocol{
	PrintWriter ow;
	
	
	public OutputManager(OutputStream out) throws IOException {
		this.ow = new PrintWriter(out, true);
	}

    @Override
    public void askListMagasin() throws IOException {

    }

    @Override
	public void askZone(long id) throws IOException {
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
	public void createZone(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBorne(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateZone(long id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBorne(Borne borne) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askBorne(long id) throws IOException {
		// TODO Auto-generated method stub
		
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
	public void askListBornes() throws IOException {
		
	}

	@Override
	public void askListZones() throws IOException {
		// TODO Auto-generated method stub
		
	}


	// IMPLEMENT METHODES DU PROTOCOL POUR ENVOI JSON AU CLIENT
	
}
