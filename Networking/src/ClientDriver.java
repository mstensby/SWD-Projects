/**
 * This class is a driver class that creates the client instantiation and then calls the method that turns the client-side on
 */
public class ClientDriver {
    public static void main(String args[]){
        Client client = new Client();
        client.runClient();
    }
}
