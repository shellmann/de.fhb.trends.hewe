
public class GenerateUser {
	private String ID;
	private String Name;
	private String Vorname;
	private String Type;
	private String Geburtsort;
	
	public GenerateUser () {
		
	}
	
	public GenerateUser (String _ID, String _Name, String _Vorname, String _Type, String _Geburtsort) {
		setID(_ID);
		setName(_Name);
		setVorname(_Vorname);
		setType(_Type);
		setGeburtsort(_Geburtsort);
	}
	
	//Ab hier die Setter
	public void setID (String _ID) {
		this.ID = _ID;
	}
	
	public void setName (String _Name) {
		this.Name = _Name;
	}
	
	public void setVorname (String _Vorname) {
		this.Vorname = _Vorname;
	}
	
	public void setType (String _Type) {
		this.Type = _Type;
	}
	
	public void setGeburtsort (String _Geburtsort) {
		this.Geburtsort = _Geburtsort;
	}
	
	public String getID () {
		return this.ID;
	}
	
	//Ab hier die Getter
	public String getName () {
		return this.Name;
	}
	
	public String getVorname () {
		return this.Vorname;
	}
	
	public String getType () {
		return this.Type;
	}
	
	public String getGeburtsort () {
		return this.Geburtsort;
	}
	
	public String toString () {
		return "ID: " + this.ID + " Name: " + this.Name + " Vorname: " + this.Vorname + " Geburtsort: " + this.Geburtsort + " Type: " + this.Type;
	}

}
