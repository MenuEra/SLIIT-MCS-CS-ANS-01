
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class ServerThread extends Thread {
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {


//read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//convert ObjectInputStream object to String
            String message = (String) ois.readObject();
//create ObjectOutputStream object
            ObjectOutputStream obos = new ObjectOutputStream(socket.getOutputStream());
//write object to Socket
// process the message and decrement the character sent by client 1
            char c = message.charAt(0);
            char x='A';

            x = (char) (c - 1);

            obos.writeObject("The Server says "+x);
//close resources
            ois.close();
            obos.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error occured " +e.getStackTrace());
        }
    }

    private void printToALlClients(char outputString) {
        for( ServerThread sT: threadList) {
            sT.output.println(outputString);
        }

    }
}