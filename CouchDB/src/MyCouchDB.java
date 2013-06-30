import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;
import com.fourspaces.couchdb.Session;
import com.fourspaces.couchdb.ViewResults;


public class MyCouchDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Verbindung mit der CouchDB-Datenbank herstellen
		ArrayList<UserComplete> dbEntries = new ArrayList<UserComplete>();
		
		Session s = new Session ("n1moe.de", 5984);
		Database db = s.getDatabase("friends");
		
		//Wieviele Einträge sind in der DB schon vorhanden?
		int count = db.getDocumentCount();
		System.out.println("Total Documents: " + count);
		
		//Die IDs von allen Datenbankeinträgen holen
		ViewResults result = db.getAllDocuments();
		try {
			JSONObject json = new JSONObject(result);
			JSONArray myArray = new JSONArray(json.get("rows").toString());
			
			ArrayList<Document> allDocuments = new ArrayList<Document>();
			
			//Über die IDs die Einträge aus der Datenbank holen
			for (int i = 0; i < myArray.length(); i++) {
				allDocuments.add(db.getDocument(myArray.getJSONObject(i).getString("id")));
			}
			for (Document d: allDocuments) {
				if(d.get("name") != null) {
					dbEntries.add(new UserComplete(d.getId().toString(), d.get("name").toString(), d.get("vorname").toString(), d.get("geburtsort").toString()));
				}
			}
			
			for (Document d: allDocuments) {
				if(d.get("name") == null) {
					for (int j = 0; j < dbEntries.size(); j++) {
						if (d.get("kontakt_ID").equals(dbEntries.get(j).getID())) {
							dbEntries.get(j).setTelefonnummer(d.getId());
							dbEntries.get(j).setTelefonart(d.get("telefonart").toString());
						}
					}
				}
			}						
			for (UserComplete u: dbEntries) {
				System.out.println(u.toString());
			}						
		} catch (JSONException e) {			
			e.printStackTrace();
		}
		MyGui myGui = new MyGui();
		myGui.setBounds(10, 10, 500, 500);
		myGui.setVisible(true);
		
		
		
		/*
		//Kontakt erzeugen
		GenerateUser myUser = new GenerateUser("thomas", "meier", "thomas", "kontakt", "oldenburg");
		
		Document newUser = new Document();
		newUser.put("_id", myUser.getID());
		newUser.put("geburtsort", myUser.getGeburtsort());
		newUser.put("name", myUser.getName());
		newUser.put("vorname", myUser.getVorname());
		newUser.put("type", myUser.getType());
		db.saveDocument(newUser);
		
		System.out.println("Der Eintrag mit den Daten:\n" + newUser.toString() + "\nwurde erflolgreich erzeugt!\n");
		*/ 
		
		/*
		//Telefonnummer erzeugen
		GeneratePhone myPhone = new GeneratePhone("(09876)333-98765", "thomas", "haustelefon", "telefon", "(09876)333-98765");
		
		Document newPhone = new Document();
		newPhone.put("_id", myPhone.getID());
		newPhone.put("kontakt_ID", myPhone.getKontaktID());
		newPhone.put("telefonart", myPhone.getTelefonart());
		newPhone.put("telefonnummer", myPhone.getTelefonnummer());
		newPhone.put("type", myPhone.getType());
		db.saveDocument(newPhone);
		
		System.out.println("Der Eintrag mit den Daten:\n" + myPhone.toString() + "\nwurde erflolgreich erzeugt!\n");
		*/
	}
	

}
