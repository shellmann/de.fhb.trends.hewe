
public class GeneratePhone {
	private String ID;
	private String KontaktID;
	private String Telefonart;
	private String Type;
	private String Telefonnummer;
	
	public GeneratePhone () {
		
	}
	
	public GeneratePhone (String _ID, String _KontaktID, String _Telefonart, String _Type, String _Telefonnummer) {
		setID(_ID);
		setKontaktID(_KontaktID);
		setTelefonart(_Telefonart);
		setType(_Type);
		setTelefonnummer(_Telefonnummer);
	}
	
	//Ab hier die Setter
	public void setID (String _ID) {
		this.ID = _ID;
	}
	
	public void setKontaktID (String _KontaktID) {
		this.KontaktID = _KontaktID;
	}
	
	public void setTelefonart (String _Telefonart) {
		this.Telefonart = _Telefonart;
	}
	
	public void setType (String _Type) {
		this.Type = _Type;
	}
	
	public void setTelefonnummer (String _Telefonnummer) {
		this.Telefonnummer = _Telefonnummer;
	}
	
	public String getID () {
		return this.ID;
	}
	
	//Ab hier die Getter
	public String getKontaktID () {
		return this.KontaktID;
	}
	
	public String getTelefonart () {
		return this.Telefonart;
	}
	
	public String getType () {
		return this.Type;
	}
	
	public String getTelefonnummer () {
		return this.Telefonnummer;
	}
	
	public String toString () {
		return "ID: " + this.ID + " KontaktID: " + this.KontaktID + " Telefonnummer: " + this.Telefonnummer + " Telefonart: " + this.Telefonart + " Type: " + this.Type;
	}

}
