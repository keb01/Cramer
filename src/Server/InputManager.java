package Server;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import Model.Borne;
import Model.Personne;
import Model.Profil;
import Model.Vente;
import Model.Zone;

public class InputManager {
	AppProtocol handler;
	InputStream in;
	
	public InputManager(InputStream in, AppProtocol handler) throws IOException {
		this.in = in;
		this.handler = handler;
	}
	
	
	public void doRun() throws IOException, JSONException {
		String json;
		String line = null;
		ObjectMapper mapper = new ObjectMapper();
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			
			while ((line = is.readLine()) != null) {
				System.out.println("CLIENT ASKING : "+line);
				//InputQuery query = mapper.readValue(line, InputQuery.class);
				/*
				JSON Object from input query
				*/
				JSONObject query = new JSONObject(line);
				String queryType = query.getString("queryType");
				String table = query.getString("table");
				JSONObject param = query.getJSONObject("param");
				System.out.println("param = "+param);

                switch (queryType) {
				case "LIST":
					switch (table) {
					case "ZONE":
						handler.askListZones();
						break;
					case "BORNE":
						handler.askListBornes();
						break;
					case "VENTECLIENTX":
						handler.askListVentesClientX(param.getLong("id"));
						break;
					default:
						break;
					}
					
					break;
				case "FIND":
					switch (table) {
					case "ZONE":
						handler.askZone(param.getLong("id"));
						break;
					case "BORNE":
						handler.askBorne(param.getLong("id"));
						break;
					case "PROFIL":
						handler.askProfil(param.getLong("id"));
						break;
					case "PERSONNE":
						handler.askPersonne(param.getLong("id"));
						break;
					case "VENTE":
						handler.askVente(param.getLong("id"));
						break;
					case "CATEGORIEVENTEX":
						handler.askVente(param.getLong("id"));
						break;
					default:
						break;
					}
					
					break;	
				case "DELETE":
					
					switch (table) {
					case "ZONE":
						handler.delZone(param.getLong("id"));
						break;
					case "BORNE":
						handler.delBorne(param.getLong("id"));
						break;
					case "PROFIL":
						handler.delProfil(param.getLong("id"));
						break;
					case "PERSONNE":
						handler.delPersonne(param.getLong("id"));
						break;
					case "VENTE":
						handler.delVente(param.getLong("id"));
						break;
					default:
						break;
					}
					
					break;
				case "INSERT":
					
					switch (table) {
					case "ZONE":
						Zone zone = new Zone(param.getLong("id"),param.getString("nom"),param.getString("description"),param.getDouble("coefP"));
						handler.createZone(zone);
						break;
					case "BORNE":
						Borne borne = new Borne(-1,new Zone(param.getInt("idZone"), "", "", 0));
						System.out.println("BORNE TO ADD :  "+param.getInt("idZone"));
						handler.createBorne(borne);
						break;
					case "PROFIL":
						Profil profil = new Profil(param.getLong("id"),param.getString("nomProfil"));
						handler.createProfil(profil);
						break;
					case "PERSONNE":
						Personne personne = new Personne(param.getLong("id"), param.getString("nom"), param.getString("prenom"), param.getLong("age"), param.getString("adresse"), param.getLong("codePostal"), param.getString("ville"), param.getLong("idProfil"));
						handler.createPersonne(personne);
						break;
					case "VENTE":
						Vente vente = new Vente(param.getLong("id"),param.getLong("idArticle"),param.getLong("idEmploye"),param.getLong("idClient"),param.getLong("quantite"),param.getLong("prix"),param.getString("dateVente"));
						handler.createVente(vente);
						break;
					default:
						break;
					}
					
					break;
				case "UPDATE":
					
					switch (table) {
					case "ZONE":
						Zone zone = new Zone(param.getLong("id"),param.getString("nom"),param.getString("description"),param.getDouble("coefP"));
						handler.updateZone(zone);
						break;
					case "BORNE":
						Borne borne = new Borne(param.getLong("id"),new Zone(param.getLong("idZone"), "", "", 0));
						handler.updateBorne(borne);
						break;
					case "PROFIL":
						Profil profil = new Profil(param.getLong("id"),param.getString("nomProfil"));
						handler.updateProfil(profil);
						break;
					case "PERSONNE":
						Personne personne = new Personne(param.getLong("id"), param.getString("nom"), param.getString("prenom"), param.getLong("age"), param.getString("adresse"), param.getLong("codePostal"), param.getString("ville"), param.getLong("idProfil"));
						handler.updatePersonne(personne);
						break;
					case "VENTE":
						Vente vente = new Vente(param.getLong("id"),param.getLong("idArticle"),param.getLong("idEmploye"),param.getLong("idClient"),param.getLong("quantite"),param.getLong("prix"),param.getString("dateVente"));
						handler.updateVente(vente);
						break;
					default:
						break;
					}
					
					break;
				default:
					break;
				}

			}
		}
	}
}
