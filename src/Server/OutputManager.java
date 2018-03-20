package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputManager implements AppProtocol{
	PrintWriter ow;
	
	
	public OutputManager(OutputStream out) throws IOException {
		this.ow = new PrintWriter(out, true);
	}

    @Override
    public void askListMagasin() throws IOException {

    }

    @Override
	public void sendListZones(String s) {
		ow.println(s);
	}

	@Override
	public void sendListBornes(String s) {
		ow.println(s);
        System.out.println(s);
	}

	@Override
	public void sendListMagasin(String s) {
		ow.println(s);
        System.out.println(s);
	}

	@Override
	public void askListBornes() throws IOException {
		
	}


	// IMPLEMENT METHODES DU PROTOCOL POUR ENVOI JSON AU CLIENT
	
}
