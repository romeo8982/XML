
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name = "klienci")
public class Clients {
    public List<Client> clients;
    public List<Client> getProducts() {
        return clients;
    }
    @XmlElement(name = "klient")
    public void setProducts(List<Client> products) {
        this.clients = products;
    }
    public void add(Client client) {
        if (this.clients == null) {
            this.clients = new ArrayList<Client>();
        }
        this.clients.add(client);
    }
}
