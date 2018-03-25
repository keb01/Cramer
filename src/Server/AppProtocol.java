package Server;

import java.io.IOException;

import Model.Borne;
import Model.Zone;

public interface AppProtocol {


    // QUERIES

    public void askListMagasin() throws IOException;
    public void askListBornes() throws IOException;
    public void askListZones() throws IOException;
    public void askZone(long id) throws IOException;
    public void askBorne(long id) throws IOException;
    
    public void delZone(long id) throws IOException;
    public void delBorne(long id) throws IOException;
    public void createZone(long id) throws IOException;
    public void createBorne(long id)throws IOException;
    public void updateZone(long id) throws IOException;
    public void updateBorne(long id) throws IOException;
    

    //ANSWERS
    public void sendListZones(String s);
    public void sendListBornes(String s);
    public void sendListMagasin(String s) throws IOException;
}
