


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * This class implements java Socket server
 * @author Menu
 *
 */
public class Server {

    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 8888;

    public static void main(String args[]) throws IOException, ClassNotFoundException{


//list to add all the clients thread
        ArrayList<ServerThread> threadList = new ArrayList<>();

//create the socket server object
        server = new ServerSocket(port);
//keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request");
//creating socket and waiting for client connection
            Socket socket = server.accept();

            ServerThread serverThread = new ServerThread(socket, threadList);
//starting the thread
            threadList.add(serverThread);
            serverThread.start();


        }

    }

}