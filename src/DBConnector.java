import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private int resultUpdate;
	
	public Clients clients = new Clients();
	public Dish helper_dish = new Dish();
	public Client helper_client = new Client(); 
	public Book helper_book = new Book(); 
	
	public DBConnector()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost/restauracja?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			st = con.createStatement();
			
			String query = "select * from danie";
			rs=st.executeQuery(query);
			while(rs.next())
			{
				String id = rs.getString("ID");
				String name = rs.getString("Nazwa");
				String price = rs.getString("Cena");
				
				helper_dish.setId(Integer.valueOf(id));
				helper_dish.setName(name);
				helper_dish.setPrice(Float.valueOf(price));
				
				helper_dish.DishList.add(helper_dish);
			}
			query = "select * from klient";
			rs=st.executeQuery(query);
			while(rs.next())
			{
				String id = rs.getString("ID");
				String surname = rs.getString("Imie");
				String name = rs.getString("Nazwisko");
				
				helper_client.setId(Integer.valueOf(id));
				helper_client.setSurName(surname);
				helper_client.setName(name);
				clients.add(helper_client);
			}
			query = "select * from zamowienie";
			rs=st.executeQuery(query);
			while(rs.next())
			{
				String id = rs.getString("ID");
				String id_client = rs.getString("Id_klienta");
				String id_dish = rs.getString("Id_dania");
				helper_book.setId(Integer.valueOf(id));
				helper_book.setId_dania(Integer.valueOf(id_dish));
				helper_book.setId_klienta(Integer.valueOf(id_client));
				helper_book.BookList.add(helper_book);
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void getData()
	{
		try {
			String query = "select * from danie";
			rs=st.executeQuery(query);
			System.out.println("Dania:");
			while(rs.next())
			{
				String id = rs.getString("ID");
				String name = rs.getString("Nazwa");
				String price = rs.getString("Cena");
				System.out.println("ID: "+ id+" Nazwa: "+ name + " Cena: " + price);
			}
			query = "select * from klient";
			rs=st.executeQuery(query);
			System.out.println("Klienci:");
			while(rs.next())
			{
				String id = rs.getString("ID");
				String surname = rs.getString("Imie");
				String name = rs.getString("Nazwisko");
				System.out.println("ID: "+ id + " Imie: "+ surname + " Nazwisko: " + name);
			}
			query = "select * from zamowienie";
			rs=st.executeQuery(query);
			System.out.println("Zamowienia:");
			while(rs.next())
			{
				String id = rs.getString("ID");
				String id_client = rs.getString("Id_klienta");
				String id_dish = rs.getString("Id_dania");
				System.out.println("ID: " + id +" Id_klienta: "+ id_client + " Id_dania: " + id_dish);
			}
		}catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void getDataDish()
	{
		try {
			 
			String query = "select * from danie";
			rs=st.executeQuery(query);
			System.out.println("Dania:");
			while(rs.next())
			{
				String id = rs.getString("ID");
				String name = rs.getString("Nazwa");
				String price = rs.getString("Cena");
				System.out.println("ID: "+ id+" Nazwa: "+ name + " Cena: " + price);
			}
		}catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void getDataClient()
	{
		try {
			
			String query = "select * from klient";
			rs=st.executeQuery(query);
			System.out.println("Klienci:");
			while(rs.next())
			{
				String id = rs.getString("ID");
				String surname = rs.getString("Imie");
				String name = rs.getString("Nazwisko");
				System.out.println("ID: "+ id + " Imie: "+ surname + " Nazwisko: " + name);
			}
		}catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void getDataBook()
	{
		try {
		
		String query = "select * from zamowienie";
		rs=st.executeQuery(query);
		System.out.println("Zamowienia:");
		while(rs.next())
		{
			String id = rs.getString("ID");
			String id_client = rs.getString("Id_klienta");
			String id_dish = rs.getString("Id_dania");
			System.out.println("ID: " + id +" Id_klienta: "+ id_client + " Id_dania: " + id_dish);
		}
		}catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void setDataClient(String Surname,String LastName)
	{
		try
		{
			String query = "INSERT INTO `klient` (`ID`, `Imie`, `Nazwisko`) VALUES (NULL, '"+Surname+"', '"+LastName+"')";
			resultUpdate = st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void setDataDish(String Name,float price)
	{
		try
		{
			String query = "INSERT INTO `danie` (`ID`, `Nazwa`, `Cena`) VALUES (NULL, '"+Name+"', '"+price+"')";
			resultUpdate = st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void setDataBook(int Id_Client,int Id_Dish)
	{
		try
		{
			String query = "INSERT INTO `zamowienie` (`ID`, `Id_klienta`, `Id_dania`) VALUES (NULL, '"+Id_Client+"', '"+Id_Dish+"')";
			resultUpdate = st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void UpdateClient(String Surname,String LastName, int id)
	{
		try
		{
			String query = "UPDATE `klient` SET `Imie` = '"+Surname+"', `Nazwisko` = '"+LastName+"' WHERE `klient`.`ID` = "+id+"";
			resultUpdate = st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void UpdateDish(String name,float price, int id)
	{
		try
		{
			String query = "UPDATE `danie` SET `Nazwa` = '"+name+"', `Cena` = '"+price+"' WHERE `danie`.`ID` = "+ id +"";
			resultUpdate = st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void UpdateBook(int Id_Client,int Id_Dish, int id)
	{
		try
		{
			String query = "UPDATE `zamowienie` SET `Id_klienta` = '"+Id_Client+"', `Id_dania` = '"+Id_Dish+"' WHERE `zamowienie`.`ID` = "+id+"";
			resultUpdate = st.executeUpdate(query);
		}
		catch(Exception ex)
		{
			System.out.println("Error: " +ex);
		}
	}
	
	public void Close()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
