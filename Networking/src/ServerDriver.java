/**
 * The purpose of this class is solely to create an instance of the class Server and to start up the server itself.
 */
public class ServerDriver {
    public static void main(String[] args) {
        Server server = new Server();
        server.runServer();
    }
}