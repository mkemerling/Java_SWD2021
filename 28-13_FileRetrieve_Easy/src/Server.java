import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This is the Server Class that gets run through ServerTest, this is the server for the connection
 */
public class Server {
    /**
     * This is the private variable for the output stream
     */
    private ObjectOutputStream output; // output stream to client
    /**
     * This is the private variable for the input stream
     */
    private ObjectInputStream input; // input stream from client
    /**
     * This is the ServerSocket variable
     */
    private ServerSocket server; // server socket
    /**
     * This is the socket connection
     */
    private Socket connection; // connection to client
    /**
     * This can be used for a multi-client program
     */
    private int counter = 1; // counter of number of connections

    // set up and run server

    /**
     * This method is to set up and run the server it calls the stream and process connection methods, from the textbook code
     */
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(23765, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } catch (EOFException eofException) {
                    // displayMessage("\nServer terminated connection");
                    System.out.println("Error with connection");
                } finally {
                    closeConnection(); //  close connection
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("Error with connection");
        }
    }

    // wait for connection to arrive, then display connection info

    /**
     * This is the waiting for connection method, from the textbook code
     * @throws IOException Throws an IO Exception
     */
    private void waitForConnection() throws IOException {
        System.out.println("Waiting for connection");
        connection = server.accept(); // allow server to accept connection
        System.out.println("Connection received from:" + connection.getInetAddress().getHostName());
    }

    // get streams to send and receive data

    /**
     * This is the get Streams method it sets up output, and flushes the output , from the textbook code
     *
     * @throws IOException Throws an IO Exception
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        System.out.println("Got I/O streams");
    }

    // process connection with client

    /**
     * This is the processConnection class where once the connection is established it can send and receive data,
     * where most of my implementation occurs
     * @throws IOException Throws an IO exception
     */
    private void processConnection() throws IOException {
        // Successful connection
        String message = "Connection successful";
        sendData(message); // send connection successful message

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read from input
                System.out.println(message); // print out the message
                // if its terminate
                if (message.equals("Terminate")) {
                    sendData("Terminate");
                } else { // if it isn't terminate
                    StringBuilder returnFile = new StringBuilder(); // to read within the file
                    try { // try to find it
                        File file = new File("/iahome/m/mm/mmkemerling/Desktop/GIT/mmkemerling_swd/oral_exam2/28-13_FileRetrieve_Easy/src/" + message);

                        Scanner scanner = new Scanner(file);//to scan the file
                        while (scanner.hasNext()) { //while there is a next line to scan
                            returnFile.append(scanner.nextLine());
                        }
                    } catch (FileNotFoundException exception) { // if the file doesnt exist
                        returnFile.append("File not found");
                    }
                    sendData(returnFile.toString()); // sends the data

                }
                //System.out.println(message);
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("Unknown object type received");
            }
            // if terminate happens
        } while (!message.equals("Terminate"));
    }

    // close streams and socket
    /**
     * Method to close the connection, from the textbook example
     * It throws an IO Exception if unable to
     */
    private void closeConnection() {
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // send message to client

    /**
     * This is the send data method, that sends the data to the client, from the textbook
     *
     * @param message
     */
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject(message);
            output.flush(); // flush output to client
            //displayMessage("\nSERVER>>> " + message);
            System.out.println(message);
        } catch (IOException ioException) {
            //displayArea.append("\nError writing object");
            System.out.println("error in writing object");
        }
    }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.
 /**************************************************************************/
