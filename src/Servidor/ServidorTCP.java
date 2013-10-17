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

    public ServidorTCP() throws IOException {
        proxyServidor = new ProxyServidor();
        welcomeSocket = new ServerSocket(6789);
    }

    public void recibirMensaje(){
        try {
            System.out.println("recibido");
            Socket conexionSocket = welcomeSocket.accept();
            BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(conexionSocket.getInputStream()));
            while((mensajeRecibido = entradaServidor.readLine()) != null){
                System.out.println(mensajeRecibido);
            }
            
            
        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje servidor" + excepcion.getMessage());
        }
    }

    public void enviarMensaje() {
    }

    public void llamarAlServicio() {
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
