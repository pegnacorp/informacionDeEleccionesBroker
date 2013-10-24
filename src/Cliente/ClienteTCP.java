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
         
//         clientSocket.close();
         
         
        }catch(Exception excepcion){
            JOptionPane.showMessageDialog(null, "Mensaje Cliente" + excepcion.getMessage());
        }
    }
}
