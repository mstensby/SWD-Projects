import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class is used to act as the client side of a client-server relationship. This is done through creating a GUI
 * where the user is able to request the name of a text file. After this is done, the contents will be sent by the server
 * so the client can then modify the contents of the file. After the modification is complete, the user will then be able
 * to send the modified contents back to the server.
 */
public class Client extends JFrame {
    /**
     * Output stream to client
     */
    private ObjectOutputStream output; // output stream to client
    /**
     * input stream from client
     */
    private ObjectInputStream input; // input stream from client
    /**
     * Socket connection that is made with the server
     */
    private Socket connection; // connection to client
    /**
     * text are that allows the user to request a file and modify the contents of the file
     */
    private JTextArea display;
    /**
     * holds the name of the file that the user requested
     */
    private String fileName;
    /**
     * holds the requested modifications made by the user
     */
    private String requestedMods;

    /**
     * The constructor is used for creating the GUI as well as adjusting what happens with the user input.
     */
    public Client(){
        super("Client");
        display = new JTextArea(20, 40); // the display is used to show the contents of the file
        setLayout(new BorderLayout());
        add(new JScrollPane(display), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton userRequestButton = new JButton("Request File"); // creates the first button to request the file
        userRequestButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fileName = display.getText();
                    System.out.println("You requested " + fileName); // gets the fileName from the text field
                    output.writeObject(fileName); // Sends the name of the file to the server
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JButton userModifyButton = new JButton("Double click to Modify File"); // creates the second button to modify the file
        userModifyButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requestedMods = display.getText();
                try {
                    output.writeObject(requestedMods); // sends the modified contents to the server
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonPanel.add(userRequestButton);
        buttonPanel.add(userModifyButton);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * The purpose of this method is to attempt to connect to the server and if it is successful then the I/O streams
     * are set up and the file is processed by the client.
     */
    public void runClient(){
        try {
            connectServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            getIO();
            processFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * establishes the connection to the socket that was opened by the server
     * @throws IOException
     */
    private void connectServer() throws IOException {
      connection = new Socket(InetAddress.getByName("localhost"),23651); // established connection with server
    }

    /**
     * creates streams so that the client and server are able to send and receive data
     * @throws IOException
     */
    private void getIO() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        input = new ObjectInputStream(connection.getInputStream());
    }


    /**
     * This method is what allows the display area to show the file's contents to the client.
     * @throws IOException
     */
    private void processFile() throws IOException {
        try {
            String clientRequest = (String) input.readObject();
            while(clientRequest.equals("Does not exist")){
                clientRequest = (String) input.readObject(); // receives from the server and then displays the contents
            }
            display.setText(clientRequest);
        } catch (ClassNotFoundException e) { // class not found an IO exception must be thrown if there is any issues while trying to read the object from the file
            throw new RuntimeException(e);
        }
    }

}

