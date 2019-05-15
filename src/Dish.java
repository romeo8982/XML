import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dish {
	private int ID;
	private String Nazwa;
	private float Cena;
	
	public ArrayList<Dish> DishList = new ArrayList<Dish>();
	
	public String getName() {
		return Nazwa;
	}
	@XmlElement
	public void setName(String name) {
		Nazwa = name;
	}
	public float getPrice() {
		return Cena;
	}
	@XmlElement
	public void setPrice(float price) {
		Cena = price;
	}
	public int getId() {
		return ID;
	}
	
	@XmlAttribute
	public void setId(int id) {
		ID = id;
	}
}
