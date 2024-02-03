import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is responsible for all the server-side logic. In specific, this class initializes the socket connection,
 * waits for a connection to be established from the client, waits for the client to request a file, sends that files
 * contents to the client, and then finally will change the contents of the file to the desired user input.
 */
public class Server {
    /**
     * output stream to client
     */
    private ObjectOutputStream output;
    /**
     * input stream from client
     */
    private ObjectInputStream input;
    /**
     * server socket
     */
    private ServerSocket server;
    /**
     * connection to the client
     */
    private Socket connection;

    /**
     * Used for capturing the file request
     */
    private String userInput;
    /**
     * Used for reading the text file line by line
     */
    private BufferedReader bufferedReader;
    /**
     * Captures the file modifications made by the user
     */
    private String modified;

    /**
     * This method is responsible for waiting for the connection, setting up the IO streams, and processing the file
     * request as well as the modified version of the file.
     */
    public void runServer(){
        try {
            server = new ServerSocket(23651);
            waitForConnection();
            getIO();
            while (true) { // This while loop loops forever until the exit condition is met (the connection closing)
                    userInput = (String) input.readObject(); // dynamically casts file request to a string
                    if(userInput.equals("Networking.txt")){
                        processRequest(userInput);
                    }
                    else{
                        processModify();
                        System.out.println("The modified contents of the file is: " + modified);
                        connection.close();
                    }
                }
            }catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    /**
     * waits for a connection to be established by the client.
     */
    private void waitForConnection() {
        System.out.println("Server is waiting for connection...\n");
        try {
            connection = server.accept(); // If the server is not able to accept any incoming messages,
            // then throw an exception (something that is only detectable during the execution of the program)
            System.out.println("Connection successful with client");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is what allows the server to send the contents of the file to the client
     * @param userInput tracks what the user inputted
     * @throws IOException if there is a problem when establishing the IO streams
     */
    private void processRequest(String userInput) throws IOException {
        try {
            System.out.println("User requested the file " + userInput);
            File file = new File(getClass().getResource(userInput).toURI()); // where exception could occur. had error here but then suggestion from TA for toURI
            FileReader reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader); // allows the server to read the content of the file to the client
            String textFile = "";
            String fileLine;
            while(( fileLine= bufferedReader.readLine())!=null){
                textFile = textFile + fileLine + "\n";
            }
            System.out.println("This is the current text inside the file: " + textFile);
            output.writeObject(textFile); // where exception could occur
        } catch (FileNotFoundException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Allows the server to take in the modified content modifies the file's contents
     * @throws IOException if there is no input or output for the file
     */
    private void processModify() throws IOException, ClassNotFoundException {
            modified = (String) input.readObject();
            // find a way to open the file (File I/O)
            System.out.println("This is the modified version from client: " + modified);
            Path path = Paths.get("/iahome/m/ms/mstensby/IdeaProjects/mstensby/oral_exam2/Networking/resources/Networking.txt");
            Files.write(path, modified.getBytes());
    }

    /**
     * Creates the input and output streams for the file
     * @throws IOException if there is an issue while setting up the output streams
     */
    private void getIO() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        input = new ObjectInputStream(connection.getInputStream());
    }
}
