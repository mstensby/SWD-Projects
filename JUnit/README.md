[Home](https://github.com/mstensby)

### Problem Statement
This problem is a 3 part problem. 

First, the task at hand is to develop a program that can encode and decode any Postal Service Zip Code(ZIP,ZIP+4, or ZIP+4+delivery) into its very own POSTNET (Postal Numeric Encoding Technique) code. When encoding, output the POSTNET in the binary format as well as a special format where any 0 = ., and any 1=|. Make sure to compute the checksum both ways (decoding and encoding). Use the conversions from binary to decimal listed below:

[ZIP Conversions](https://uiowa.instructure.com/courses/207734/files/23406322/preview)

Next, the goal develop a program that can encode and decode binary encoded UPC-A barcodes. Input to the encoder should be the 11 digit product code, output should be the encoded barcode (with guard bars and check digit). The input for the decoder should be the encoded barcode, and the output should be the check digit and the product code. Make sure to add/take the guard bars into consideration when converting to and from the barcode. Use the conversions for the encoding listed below:

[Link#1](https://courses.cs.washington.edu/courses/cse370/01au/minirproject/TeamUPC/UPC.html)

[Link#2](https://en.wikipedia.org/wiki/Universal_Product_Code#Encoding)

Make sure to create JUnit test casing for the first two programs. The purpose of the JUnit is to do exhaustive tests to see how your program reacts to certain inputs. 

Lastly, You must develop a GUI program that allows the user to input a URL. The output should be a display of the URL in the form of a QR code. This can be done through the use of Swing GUI, which includes an Action Listener and a Bit to Matrix converter for the conversion from the URL to QR code. 

### User Documentation
For the first program, simply run it and then type in the ZIP code that you wish to encode or POSTNET Barcode you wish to decode. the rest will work on its own and it will output the decoded/encoded information necessary.

For the second program, simply run it and then type in the UPC-A barcode or product code you wish to encode/decode and the rest will work on its own. 

For the last, simply run it and type in the URL you wish to put into a QR Code. Press the button "Generate" and then "ok" and then a picture will display your QR Code. Test it with your phone!

### Developer Documentation
The first program uses 5 methods for encoding the ZIP code into its binary representation. These methods capture the user's input, find the associated checksum, create the final ZIP code which includes the checksum, and convert and display the number into its binary representation and the encoded representation. For the decoding portion, there are 3 methods that take in the binary encoded ZIP, deletes all guards, removes the binary representation of the check digit, and then converts the ZIP into its decimal representation.

The second program's encoding portion uses 3 methods, but those three methods are very important. One is used for the entire encoding process, another is used for obtaining the user's input, and the other is only used for calculating the check digit. For the decoding portion, there are 2 methods. One is for obtaining the user input, and the other is used for decoding the binary digit.

For the third program, there are 3 methods. The most important method is the method that creates and displays the window and sets all of its contents to be usable in the future. The second method is the action listener. This method waits for a user input and then uses the 3rd method, which converts the URL inputted by the user into a QR code. 

[src JavaDocs](http://localhost:8400/mstensby/oral_exam1/JUnit/doc/JUnitPackage/package-summary.html)

[JUnit JavaDocs](http://localhost:8400/mstensby/oral_exam1/JUnit/docJUnitTesting/EncodeUPCJUnitTest.html)

![image](https://github.com/mstensby/SWD-Projects/assets/156954799/748bfdcc-c557-4cbf-bfc3-97903adbbcd6)


### Source Code
[resources](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/tree/main/oral_exam1/JUnit/resources)

[com folder](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/tree/main/oral_exam1/JUnit/src/com)

[src folder](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/tree/main/oral_exam1/JUnit/src)

[JUnitPackage](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/tree/main/oral_exam1/JUnit/src/JUnitPackage)

[DecodePostNet.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/DecodePostNet.java)

[DecodePostNetDriver.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/DecodePostNetDriver.java)

[EncodePostNet.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/EncodePostNet.java)

[EncodePostNetDriver.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/EncodePostNetDriver.java)

[DecodeUPC.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/DecodeUPC.java)

[DecodeUPCDriver.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/DecodeUPCDriver.java)

[EncodeUPC.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/EncodeUPC.java)

[EncodeUPCDriver.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/EncodeUPCDriver.java)

[QRCode.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/QRCode.java)

[QRCodeDriver.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/src/JUnitPackage/QRCodeDriver.java)

[Test folder](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/tree/main/oral_exam1/JUnit/Test)

[DecodePostNetJUnitTest.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/Test/DecodePostNetJUnitTest.java)

[EncodePostNetJUnitTest.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/Test/EncodePostNetJUnitTest.java)

[DecodeUPCJUnitTest.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/Test/DecodeUPCJUnitTest.java)

[EncodeUPCJUnitTest.java](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/Test/EncodeUPCJUnitTest.java)

[JUnit.iml](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam1/JUnit/JUnit.iml)
