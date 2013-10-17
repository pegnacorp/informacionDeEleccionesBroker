/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import socket.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author user
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
     private Socket clientSocket;
    public ClienteTCP() throws UnknownHostException, IOException{
        
         clientSocket = new Socket("localhost", 6789);
    }
    
    public void enviarMensaje(String mensaje) throws IOException{
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
         outToServer.writeBytes(mensaje + '\n');
    }
    
    public void recibirMensaje(){
        
    }
    
//    public static void main(String[] args) throws IOException {
//        String sentence;
//        String modifiedSentence;
//
////        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//
//        Socket clientSocket = new Socket("localhost", 6789);
////enviar
//        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
////recibir
//        BufferedReader inFromServer =
//                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
////        sentence = inFromUser.readLine();
//
//        outToServer.writeBytes(sentence + '\n');
//
//        modifiedSentence = inFromServer.readLine();
//
//        System.out.println("Del servidor: " + modifiedSentence);
//
//        clientSocket.close();
//
//    }
}
