package JUnitPackage;

import com.com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Description: Creates an application that converts the user's URL to a readable QR Code. This is done through creating
 * and image holder, also known as an ImageIcon, which is then later converted into the URL of the user. This class
 * also uses many Swing components to allow the user to type in their URL, click the 'Generate' and 'OK' button.
 * Swing also allows for the button to be used as the marker that the user wants whatever is inside their text field
 * to be converted to a QR Code. The actual conversion step is done through a BitMatrix encoder.
 */
public class QRCode extends JFrame{
    /**
     *  Holds the path of the QR Code that is used as an example
     */
    private final String path = "/iahome/m/ms/mstensby/IdeaProjects/mstensby/oral_exam1/JUnit/resources/QRCode.png"; // The path of the example JUnitPackage.QRCode png
    /**
     * Holds the path that the new QR Code will be saved into
     */
    private final String toURL = "/iahome/m/ms/mstensby/IdeaProjects/mstensby/oral_exam1/JUnit/resources/QRCodeNew.png";
    /**
     * To allow access to the file system inside the JVM for the new QR Code to be saved
     */
    Path pathOut = FileSystems.getDefault().getPath(toURL); // Allows ability to output the new QR code to its own png

    /**
     * Creates an Image of the example QR Code that can later be displayed in a window frame
     */
    private ImageIcon qRImageIcon= new ImageIcon(path);
    /**
     * Purpose: Allows the User to type in the window
     */
    private JTextField userTextField;

    /**
     * Uses a Matrix to convert the URL inputted in the text field into a QR Code
     * @throws WriterException If the conversion from URL to QR does not work
     * @throws IOException If the new file that has been created for the new QR Code does not output properly
     */
   private void linkToQR()
           throws WriterException, IOException
   {
       BitMatrix qrEncoder = new MultiFormatWriter().encode(userTextField.getText(),
               BarcodeFormat.QR_CODE, 500, 500);
       MatrixToImageWriter.writeToPath(qrEncoder, "PNG", pathOut);
       // Tells where the QR code should be placed once created

   }

    /**
     * Creates the window and sets the button that is used to confirm that what is inside the text box is what
     * needs to be converted into a QR Code, the text field for the user, the Example QR Code, and the window itself
     */
// All of this method could have been done in the constructor so it would be created at runtime instead of having
    // to run the whole thing
   public void windowCreator(){
       JButton myButton = new JButton("Generate");
       JFrame myFrame = new JFrame("QR Code Generator"); // initiates a new frame and sets the title of the frame
       userTextField = new JTextField(30); // initiates the text field for the user to input their URL
       JPanel userPanel = new JPanel();
       // Initiates the container for that allows for multiple items to be placed in one section of the screen
        // These 2 "add" methods add the user's text and the button to its own "container," which is then put into the overall frame
       userPanel.add(userTextField);
       userPanel.add(myButton);
         // Sets the window frame display
       myFrame.setPreferredSize(new Dimension(500,500)); // sets the size of the frame
       myFrame.add(new JLabel(qRImageIcon), BorderLayout.CENTER); // adds the example JUnitPackage.QRCode to the start screen
       myFrame.add(new JLabel("This is an example QR Code: "), BorderLayout.NORTH); //caption
       myFrame.add(userPanel, BorderLayout.SOUTH); // Adds the text field and button to the south end of frame
       myFrame.pack(); // sizes the frame so that all its contents are at or above their preferred sizes
       myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes the program stop running after window is closed
       ButtonHandler handler = new ButtonHandler();
       myButton.addActionListener(handler); // listens to the user input (button press in this case)
       myFrame.setVisible(true); // Allows the frame to be visible to the user
    }

    /**
     * Waits until the button is pressed and then converts what the User inputted into a readable QR Code
     */
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            // waits until action is preformed (push of button) and then generates the new QR image
            JOptionPane.showMessageDialog(QRCode.this, String.format(
                    "Are you sure you want to %s", event.getActionCommand() + " a QR Code...?"));
            try {
                linkToQR();
            } catch (WriterException e) {    // If creating the QR Code somehow fails, throw an error message
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            qRImageIcon = new ImageIcon(toURL); // creates the new imageIcon
            JOptionPane.showMessageDialog(null, qRImageIcon); // shows the new JUnitPackage.QRCode image

        }
    }
}
