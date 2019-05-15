import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args){
		DBConnector connect = new DBConnector();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);	
		String surname,name,dish,price,id_client,id_dish;
		int choose_int,id;
		
		do
		{
		System.out.println("1: Dodaj klienta");
		System.out.println("2: Dodaj danie");
		System.out.println("3: Dodaj zamowienie");
		System.out.println("4: Zmien dane klienta");
		System.out.println("5: Zmien dane dania");
		System.out.println("6: Zmien dane zamowienie");
		System.out.println("7: Wyswietl");
		System.out.println("8: Import XML");
		System.out.println("9: Export klienta XML");
		System.out.println("10: Export dania XML");
		System.out.println("11: Export zamowienia XML");
		System.out.println("12: Koniec");
		String choose = scan.nextLine();
		choose_int=(Integer.valueOf(choose));
		switch(choose_int)
		{
		case 1:
			Client helper_client = new Client(); 
			System.out.println("Podaj imie");
			surname = scan.nextLine();
			System.out.println("Podaj nazwisko");
			name = scan.nextLine();
			connect.helper_client.setId(connect.clients.clients.get((connect.clients.clients.size() - 1)).getId()+1);
			helper_client.setSurName(surname);
			helper_client.setName(name);
			connect.clients.add(helper_client);
			connect.setDataClient(surname, name);
			break;
		case 2:
			Dish helper_dish = new Dish();
			System.out.println("Podaj nazwe");
			dish = scan.nextLine();
			System.out.println("Podaj cene");
			price = scan.nextLine();
			helper_dish.setId(helper_dish.DishList.get((helper_dish.DishList.size() - 1)).getId()+1);
			helper_dish.setName(dish);
			helper_dish.setPrice(Float.valueOf(price));
			helper_dish.DishList.add(helper_dish);
			connect.setDataDish(dish, Float.parseFloat(price));
			break;
		case 3:
			Book helper_book = new Book();
			System.out.println("Podaj Id_klienta");
			id_client = scan.nextLine();
			System.out.println("Podaj Id_dania");
			id_dish = scan.nextLine();
			helper_book.setId(helper_book.BookList.get((helper_book.BookList.size() - 1)).getId()+1);
			helper_book.setId_klienta(Integer.valueOf(id_client));
			helper_book.setId_dania(Integer.valueOf(id_client));
			helper_book.BookList.add(helper_book);
			connect.setDataBook(Integer.valueOf(id_client), Integer.valueOf(id_dish));
			break;
		case 4:
			System.out.println("Podaj imie");
			surname = scan.nextLine();
			System.out.println("Podaj nazwisko");
			name = scan.nextLine();
			System.out.println("Podaj id_klienta");
			id = (Integer.valueOf(scan.nextLine()));
			connect.UpdateClient(surname, name, id);
			break;
		case 5:
			System.out.println("Podaj nazwe");
			dish = scan.nextLine();
			System.out.println("Podaj cene");
			price = scan.nextLine();
			System.out.println("Podaj id_dania");
			id = (Integer.valueOf(scan.nextLine()));
			connect.UpdateDish(dish,  Float.parseFloat(price), id);
			break;
		case 6:
			System.out.println("Podaj Id_klienta");
			id_client = scan.nextLine();
			System.out.println("Podaj Id_dania");
			id_dish = scan.nextLine();
			System.out.println("Podaj id_zamowienia");
			id = (Integer.valueOf(scan.nextLine()));
			connect.UpdateBook(Integer.valueOf(id_client), Integer.valueOf(id_dish),Integer.valueOf(id));
			break;
		case 7:
			connect.getData();
			break;
		case 8:
			
			break;
		case 9:
			try {
				File file = new File("C:\\Users\\Jeremiasz\\Desktop\\fileClient.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
				jaxbMarshaller.marshal(connect.clients, file);
				jaxbMarshaller.marshal(connect.clients, System.out);

		      } catch (JAXBException e) {
		    	  e.printStackTrace();
		      }
			break;
		case 10:
			try {
				File file = new File("C:\\fileDish.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Dish.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
				jaxbMarshaller.marshal(connect.helper_dish, file);
				jaxbMarshaller.marshal(connect.helper_dish, System.out);

		      } catch (JAXBException e) {
		    	  e.printStackTrace();
		      }
			break;
		case 11:
			try {
				File file = new File("C:\\fileBook.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
				jaxbMarshaller.marshal(connect.helper_book, file);
				jaxbMarshaller.marshal(connect.helper_book, System.out);

		      } catch (JAXBException e) {
		    	  e.printStackTrace();
		      }
			break;
		case 12:
			break;
		default:
			System.out.println("Podaj prawidlowa opcje");
		}}while(choose_int!=12);
		connect.Close();
	}

}
