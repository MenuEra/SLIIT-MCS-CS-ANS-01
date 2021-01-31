


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class implements java socket client
 * @author Menu
 *
 */
public class ClientTwo {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
//get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

//establish socket connection to server
        socket = new Socket(host.getHostName(), 8888);
//write to socket using ObjectOutputStream
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Sending request to Socket Server");

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter String- ");

        String str = sc.nextLine();

        if(str==null)oos.writeObject("exit");

        else oos.writeObject(""+str);
//read the server response message
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message: " + message);

    }
}