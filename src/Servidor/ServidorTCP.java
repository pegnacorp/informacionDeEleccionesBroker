/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import socket.*;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ServidorTCP {

    private String mensajeRecibido;
    private ProxyServidor proxyServidor;
    private ServerSocket welcomeSocket;
        private boolean validarMensaje;

    public ServidorTCP() throws IOException {
        proxyServidor = new ProxyServidor();
        welcomeSocket = new ServerSocket(5000);
    }

    public void recibirMensaje() {
        try {
            System.out.println("recibido");
            Socket conexionSocket = welcomeSocket.accept();
            DataInputStream recibido = new DataInputStream(conexionSocket.getInputStream());
//            int accion = Integer.parseInt(mensajeRecibido.substring((mensajeRecibido.length()-1), mensajeRecibido.length()));
//            mensajeRecibido = mensajeRecibido.substring(0, (mensajeRecibido.length()-1));
            mensajeRecibido = recibido.readUTF();
//            processRequest(accion, mensajeRecibido);
            System.out.println("Mensaje Recibido");

        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje servidor" + excepcion.getMessage());
        }
    }
    
    public void mandarValidacionServicio(){
        
        
    }
    
    public void llamarAlServicio() throws FileNotFoundException, IOException {
        //revisar si va aquí proxyServidor

        proxyServidor.recibirMensaje(mensajeRecibido);

    }

    public static void main(String argv[]) throws Exception {
        ServidorTCP servidorTCP = new ServidorTCP();
       


        while (true) {
            servidorTCP.recibirMensaje();
            servidorTCP.llamarAlServicio();

//            capitalizedSentence = clientSentence.toUpperCase() + '\n';
//
//            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
