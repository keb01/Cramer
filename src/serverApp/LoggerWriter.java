package serverApp;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerWriter {
	
	private Logger log;
	private FileHandler fichier;

	public LoggerWriter(){
		this.log = Logger.getLogger("log");
		// TODO Auto-generated constructor stub
		try {
			this.fichier= new FileHandler("essai.log",0,1,true);
			this.fichier.setFormatter(new SimpleFormatter());
			this.log.addHandler(this.fichier);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FileHandler getFichier() {
		return fichier;
	}

	public void setFichier(FileHandler fichier) {
		this.fichier = fichier;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	public void setMessageLog(String message) {
		this.log.log(Level.INFO, message);
	}
	
	public void setErrorLog(String message) {
		this.log.log(Level.SEVERE, message);
	}
}
