import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * This is the client class from the textbook example
 */
public class Client
{
    /**
     * This is the private variable for the output stream
     */
    private ObjectOutputStream output; // output stream to client
    /**
     * This is the private variable for the input stream
     */
    private ObjectInputStream input; // input stream from client
    /**
     * This is the private String variable for the message
     */
    private String message = ""; // message from server
    /**
     * This is the private variable for the host server of this application
     */
    private String chatServer; // host server for this application
    /**
     * This is the private socket communication with server
     */
    private Socket client; // socket to communicate with server

    // initialize chatServer

    /**
     * This is the client constructor that sets the server
     * @param host
     */
    public Client(String host)
    {
        chatServer = host; // set server to which this client connects
    }

    // connect to server and process messages from server

    /**
     * This is the runClient method from the textbook that calls the connecting, streams, and processConnection methods
     */
    public void runClient()
    {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        }
        catch (EOFException eofException)
        {
            System.out.println("Client terminated connection");
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            closeConnection(); // close connection
        }
    }

    // connect to server

    /**
     * This method attempts to connect to the server using the student designated ports
     * @throws IOException Throws exception if it cannot connect to the server
     */
    private void connectToServer() throws IOException
    {
        System.out.println("Attempting to connect");
        client = new Socket(InetAddress.getByName(chatServer), 23765);

        // display connection information
        System.out.println("Connected to " + client.getInetAddress().getHostName());
    }

    // get streams to send and receive data

    /**
     * This method is to send and receive data, it flushes the output and sets up input
     * @throws IOException Throws exception if not
     */
    private void getStreams() throws IOException
    {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());
    }

    // process connection with server

    /**
     * This method processed the connection with server and processes the clients input
     * @throws IOException Throws IOException for class not found exception
     */
    private void processConnection() throws IOException
    {
        String fromServer = "";
        try{
            fromServer= (String) input.readObject();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not found exception");
        }

        String scan = "";
        // enable enterField so client user can send messages
       //scanning in
        Scanner scanner = new Scanner(System.in);

        do // process messages sent from server
        {
            try // read message and display it
            {
                System.out.println("Please input a file name:");
                scan = scanner.nextLine(); // getting next line

                sendData(scan); // sending the data
                fromServer= (String)input.readObject();
                System.out.println(fromServer);
            }
            catch (ClassNotFoundException classNotFoundException)
            {
                System.out.println("Unknown object type received");
            }

        } while (!fromServer.equals("Terminate"));
    }

    // close streams and socket

    /**
     * This method closes the connection when the Client calls terminate
     */
    private void closeConnection()
    {
        System.out.println("Closing connection");

        try
        {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    // send message to server

    /**
     * This method writes and flushes the message to the Server
     * @param message Takes a message as a string
     */
    private void sendData(String message)
    {
        try // send object to server
        {
            output.writeObject(message);
            output.flush(); // flush data to output
            //System.out.println(message);
        }
        catch (IOException ioException)
        {
            System.out.println("Error writing object");
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
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
