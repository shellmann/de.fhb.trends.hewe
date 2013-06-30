import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;
import com.fourspaces.couchdb.Session;
import com.fourspaces.couchdb.ViewResults;

public class MyGui extends JFrame {
	private JLabel Ueberschrift;
	private JLabel LabelName;
	private JLabel LabelVorname;
	private JLabel LabelGeburtsort;
	private JLabel LabelTelefonnummer;
	private JLabel LabelTelefonart;

	private JTextField Name;
	private JTextField Vorname;
	private JTextField Geburtsort;
	private JTextField Telefonnummer;
	private JTextField Telefonart;

	// private JList alleKontakte;
	// private JLabel alleKontakte;
	private JTable alleKontakte;

	private JButton Absenden;
	private JButton Hinzufuegen;

	public MyGui() {
		this.getContentPane().setLayout(null);

		this.initWindowStart();

		this.addWindowListener(new WindowListener() {

			public void windowClosed(WindowEvent arg0) {

			}

			public void windowActivated(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowDeactivated(WindowEvent e) {

			}

			public void windowDeiconified(WindowEvent e) {

			}

			public void windowIconified(WindowEvent e) {

			}

			public void windowOpened(WindowEvent e) {

			}

		});
	}

	public void initWindowStart() {
		ArrayList<UserComplete> dbEntries = new ArrayList<UserComplete>();
		dbEntries = viewFreunde();

		// Labels initialisieren
		Ueberschrift = new JLabel("Alle Freunde");

		// Textfelder initialisieren
		Object[][] data = new Object[2][1];
		data[0][0] = "Peter";
		data[1][0] = "Hans";
		Object[] spaltenNamen = { "Vorname" };// , "Nachname" , "Geburtsort" ,
												// "Telefonnummer"};
		alleKontakte = new JTable(data, spaltenNamen);
		// alleKontakte.setText(dbEntries.get(0).getName() + " , " +
		// dbEntries.get(0).getVorname());

		// Button initialisieren und benennen
		Hinzufuegen = new JButton("Freund Hinzufügen");

		Hinzufuegen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FreundHinzufuegenKlickt();

			}
		});
		// Position der Labels
		Ueberschrift.setBounds(10, 18, 400, 25);

		// Position der Textfelder festlegen
		alleKontakte.setBounds(5, 50, 450, 200);

		Hinzufuegen.setBounds(300, 330, 150, 30);

		// Elemente hinzufügen
		
		this.getContentPane().add(Ueberschrift);
		this.getContentPane().add(alleKontakte);
		this.getContentPane().add(Hinzufuegen);

		this.pack();

	}

	public void initWindow() {
		this.getContentPane().remove(Ueberschrift);
		this.getContentPane().remove(alleKontakte);
		this.getContentPane().remove(Hinzufuegen);

		// Labels initialisieren
		Ueberschrift = new JLabel("Füge einen Freund hinzu!");
		LabelName = new JLabel("Name");
		LabelVorname = new JLabel("Vorname");
		LabelGeburtsort = new JLabel("Geburtsort");
		LabelTelefonnummer = new JLabel("Telefonnummer");
		LabelTelefonart = new JLabel("Telefonart");

		// Textfelder initialisieren
		Name = new JTextField();
		Vorname = new JTextField();
		Geburtsort = new JTextField();
		Telefonnummer = new JTextField();
		Telefonart = new JTextField();

		// Button initialisieren und benennen
		Absenden = new JButton("Absenden");

		Absenden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				absendenClicked();

			}
		});
		// Position der Labels
		Ueberschrift.setBounds(10, 18, 400, 25);
		LabelName.setBounds(10, 58, 400, 25);
		LabelVorname.setBounds(10, 108, 400, 25);
		LabelGeburtsort.setBounds(10, 158, 400, 25);
		LabelTelefonnummer.setBounds(10, 208, 400, 25);
		LabelTelefonart.setBounds(10, 258, 400, 25);

		// Position der Textfelder festlegen
		Name.setBounds(5, 80, 400, 25);
		Vorname.setBounds(5, 130, 400, 25);
		Geburtsort.setBounds(5, 180, 400, 25);
		Telefonnummer.setBounds(5, 230, 400, 25);
		Telefonart.setBounds(5, 280, 400, 25);

		Absenden.setBounds(300, 330, 100, 30);

		// Elemente hinzufügen
		this.getContentPane().add(Ueberschrift);
		this.getContentPane().add(LabelName);
		this.getContentPane().add(LabelVorname);
		this.getContentPane().add(LabelGeburtsort);
		this.getContentPane().add(LabelTelefonnummer);
		this.getContentPane().add(LabelTelefonart);

		this.getContentPane().add(Name);
		this.getContentPane().add(Vorname);
		this.getContentPane().add(Geburtsort);
		this.getContentPane().add(Telefonnummer);
		this.getContentPane().add(Telefonart);

		this.getContentPane().add(Absenden);

		this.pack();

	}

	public void FreundHinzufuegenKlickt() {
		this.initWindow();
	}

	public void absendenClicked() {
		// Hole Name aus Textfeld:
		// String name = "";
		try {
			// Kontakt hinzufügen
			createKontakt(Telefonnummer.getText(), Name.getText(),
					Vorname.getText(), Geburtsort.getText());
			createTelefon(Name.getText() + Telefonnummer.getText(),
					Telefonart.getText(), Telefonnummer.getText());

			// name = Name.getText();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block

		}
		// Vorname.setText(name);
	}

	public void createKontakt(String Telefonnummer, String Name,
			String Vorname, String Geburtsort) {
		String ID = Name + Telefonnummer;

		Session s = new Session("n1moe.de", 5984);
		Database db = s.getDatabase("friends");

		// Kontakt erzeugen
		GenerateUser myUser = new GenerateUser(ID, Name, Vorname, "kontakt",
				Geburtsort);

		Document newUser = new Document();
		newUser.put("_id", myUser.getID());
		newUser.put("geburtsort", myUser.getGeburtsort());
		newUser.put("name", myUser.getName());
		newUser.put("vorname", myUser.getVorname());
		newUser.put("type", myUser.getType());
		db.saveDocument(newUser);

		System.out.println("Der Eintrag mit den Daten:\n" + newUser.toString()
				+ "\nwurde erflolgreich erzeugt!\n");
	}

	public void createTelefon(String KontaktID, String Telefonart,
			String Telefonnummer) {
		String ID = Telefonnummer;

		Session s = new Session("n1moe.de", 5984);
		Database db = s.getDatabase("friends");

		// Telefonnummer erzeugen
		GeneratePhone myPhone = new GeneratePhone(ID, KontaktID, Telefonart,
				"telefon", Telefonnummer);

		Document newPhone = new Document();
		newPhone.put("_id", myPhone.getID());
		newPhone.put("kontakt_ID", myPhone.getKontaktID());
		newPhone.put("telefonart", myPhone.getTelefonart());
		newPhone.put("telefonnummer", myPhone.getTelefonnummer());
		newPhone.put("type", myPhone.getType());
		db.saveDocument(newPhone);

		System.out.println("Der Eintrag mit den Daten:\n" + myPhone.toString()
				+ "\nwurde erflolgreich erzeugt!\n");
	}

	public ArrayList<UserComplete> viewFreunde() {
		// Verbindung mit der CouchDB-Datenbank herstellen
		ArrayList<UserComplete> dbEntries = new ArrayList<UserComplete>();

		Session s = new Session("n1moe.de", 5984);
		Database db = s.getDatabase("friends");

		// Wieviele Einträge sind in der DB schon vorhanden?
		int count = db.getDocumentCount();
		System.out.println("Total Documents: " + count);

		// Die IDs von allen Datenbankeinträgen holen
		ViewResults result = db.getAllDocuments();
		try {
			JSONObject json = new JSONObject(result);
			JSONArray myArray = new JSONArray(json.get("rows").toString());

			ArrayList<Document> allDocuments = new ArrayList<Document>();

			// Über die IDs die Einträge aus der Datenbank holen
			for (int i = 0; i < myArray.length(); i++) {
				allDocuments.add(db.getDocument(myArray.getJSONObject(i)
						.getString("id")));
			}
			for (Document d : allDocuments) {
				if (d.get("name") != null) {
					dbEntries.add(new UserComplete(d.getId().toString(), d.get(
							"name").toString(), d.get("vorname").toString(), d
							.get("geburtsort").toString()));
				}
			}

			for (Document d : allDocuments) {
				if (d.get("name") == null) {
					for (int j = 0; j < dbEntries.size(); j++) {
						if (d.get("kontakt_ID")
								.equals(dbEntries.get(j).getID())) {
							dbEntries.get(j).setTelefonnummer(d.getId());
							dbEntries.get(j).setTelefonart(
									d.get("telefonart").toString());
						}
					}
				}
			}
			for (UserComplete u : dbEntries) {
				System.out.println(u.toString());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return dbEntries;
	}

}
