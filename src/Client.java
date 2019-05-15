
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement(name = "klient")
public class Client {
	@XmlAttribute(name = "ID")
	private int ID;
	 @XmlElement(name = "Imie")
	private String Imie;
	 @XmlElement(name = "Nazwisko")
	private String Nazwisko;
	 
	public String getSurName() {
		return Imie;
	}
	
	public String getName() {
		return Nazwisko;
	}
	
	public int getId() {
		return ID;
	}
	
	public void setSurName(String surname) {
		Imie = surname;
	}
	public void setName(String name) {
		Nazwisko = name;
	}
	@XmlAttribute
	public void setId(int id) {
		ID = id;
	}
}
