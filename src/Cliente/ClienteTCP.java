/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
    
    public ClienteTCP() throws UnknownHostException, IOException{
        
         
    }
    
    public void enviarMensaje(String mensaje, int accion) throws IOException{
        System.out.println("enviado");
        try{
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
           
         outToServer.writeUTF(mensaje + accion);
         clientSocket.close();
         
         
        }catch(Exception excepcion){
            JOptionPane.showMessageDialog(null, "Mensaje Cliente" + excepcion.getMessage());
        }
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
