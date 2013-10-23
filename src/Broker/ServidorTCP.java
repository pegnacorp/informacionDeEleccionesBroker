/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;


import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ServidorTCP {

    private String mensajeRecibido;
    private ServerSocket welcomeSocket;
   

    public ServidorTCP() throws IOException {
       welcomeSocket = new ServerSocket(6789);
    }

    public void recibirMensaje() {
        try {
            System.out.println("recibido");
            Socket conexionSocket = welcomeSocket.accept();
            DataInputStream recibido = new DataInputStream(conexionSocket.getInputStream());
            mensajeRecibido = recibido.readUTF();
            System.out.println("Mensaje Recibido en el broker");

        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje servidor" + excepcion.getMessage());
        }
    }

    //Revisarsi va aquí
    public void enviarMensaje() throws UnknownHostException, IOException {
        ClienteTCP cliente = new ClienteTCP();
        cliente.enviarMensaje(mensajeRecibido);
        
    }

    public void llamarAlServicio() throws FileNotFoundException, IOException {
        //revisar si va aquí proxyServidor


    }

    public static void main(String argv[]) throws Exception {
        ServidorTCP servidorTCP = new ServidorTCP();
       


        while (true) {
            servidorTCP.recibirMensaje();
            servidorTCP.enviarMensaje();

//            capitalizedSentence = clientSentence.toUpperCase() + '\n';
//
//            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
