
public class UserComplete {
	private String ID;
	private String Name;
	private String Vorname;
	private String Geburtsort;
	private String Telefonnummer;
	private String Telefonart;
	
	public UserComplete () {
		
	}
	
	public UserComplete (String _ID, String _Name, String _Vorname, String _Geburtsort) {
		setID(_ID);
		setName(_Name);
		setVorname(_Vorname);
		setGeburtsort(_Geburtsort);
	}
	
	public void setID (String _ID) {
		this.ID = _ID;
	}
	
	public void setName (String _Name) {
		this.Name = _Name;
	}
	
	public void setVorname (String _Vorname) {
		this.Vorname = _Vorname;
	}
	
	public void setGeburtsort (String _Geburtsort) {
		this.Geburtsort = _Geburtsort;
	}
	
	public void setTelefonnummer (String _Telefonnummer) {
		this.Telefonnummer = _Telefonnummer;
	}
	
	public void setTelefonart (String _Telefonart) {
		this.Telefonart = _Telefonart;
	}
	
	public String getID () {
		return this.ID;
	}
	
	public String getName () {
		return this.Name;
	}
	
	public String getVorname () {
		return this.Vorname;
	}
	
	public String getGeburtsort () {
		return this.Geburtsort;
	}
	
	public String getTelefonnummer () {
		return this.Telefonnummer;
	}
	
	public String getTelefonart () {
		return this.Telefonart;
	}
	
	public String toString () {
		return this.ID + " , " + this.Name + " , " + this.Vorname + " , " + this.Geburtsort + " , " + this.Telefonnummer + " , " + this.Telefonart;
	}

}
