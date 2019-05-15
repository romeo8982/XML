import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private int ID,Id_klienta,Id_dania;
	public ArrayList<Book> BookList = new ArrayList<Book>();
	
	public int getId_dania() {
		return Id_dania;
	}
	
	@XmlElement
	public void setId_dania(int id) {
		Id_dania = id;
	}
	
	public int getId_klienta() {
		return Id_klienta;
	}
	
	@XmlElement
	public void setId_klienta(int id) {
		Id_klienta = id;
	}
	
	public int getId() {
		return ID;
	}
	
	@XmlAttribute
	public void setId(int id) {
		ID = id;
	}
}
