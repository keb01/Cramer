package Server;

import java.io.IOException;

public interface AppProtocol {


    // QUERIES

    public void askListMagasin() throws IOException;
    public void askListBornes() throws IOException;
    public void askListZones() throws IOException;

    //ANSWERS
    public void sendListZones(String s);
    public void sendListBornes(String s);
    public void sendListMagasin(String s) throws IOException;
}
