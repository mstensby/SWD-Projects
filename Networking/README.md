[Home](https://github.com/mstensby)

### Problem Statement
The purpose of this program is to build a client-server relationship. Through this relationship, the server should wait for a connection, and the client should establish a connection. After the connection is established, the user then should have the ability to request a text file, which is then displayed in the pop-up window. After the contents of the text file is displayed, the user should be able to change the contents of the file through the client. 

### User Documentation
To run the program, the user should first run the ServerDriver.java class, and then the ClientDriver.java class. This is to make sure that the server opens up the connection before the client tries to connect to it. After the connection is established, the user is able to type in the name of a file called "Networking.txt" and then click "Request File". After the button is pushed, the contents of the file will appear on screen. To modify the contents of the file, simply begin editing/adding to the words displayed on the pop-up. After the modifications look good, click the "Modify File" button to permanently change the contents of the file. 

### Developer Documentation
This program should have two classes: one for the client-side, and one for the server-side.

The purpose of the server is to create the socket that will be used by the client, and wait for the client to connect. After the connection is successful, the server will then wait for the name of the file to be requested and will send over the contents of the file. After the client modifies, the text file, the server will process the modification and permanently change the contents of the file. 

The purpose of the client is to connect to the server-created socket and then display the GUI that will be used by the user. The GUI should have a Text Area as well as two Buttons. The text area should be used for requesting the file name and modifying the file contents, while each button is used to process the requested file and to tell the server what contents should be modified in the file. 

[Networking JavaDocs](http://localhost:8000/mstensby/oral_exam2/Networking/doc/package-summary.html)

![image](https://github.com/mstensby/SWD-Projects/assets/156954799/88ad0730-5810-43f9-b1f2-99d0d3e4587e)

### Source Code
[Client](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Networking/src/Client.java)

[ClientDriver](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Networking/src/ClientDriver.java)

[Server](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Networking/src/Server.java)

[ServerDriver](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Networking/src/ServerDriver.java)

[Networking.txt](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Networking/src/Networking.txt)
