/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;


import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ServidorTCP {

        
    private Broker brokerInstance;
    private String mensajeRecibido;
    private ServerSocket welcomeSocket;
   
    

    public ServidorTCP(Broker b) throws IOException {
       brokerInstance = b;
       welcomeSocket = new ServerSocket(6789);
    }

    public void recibirMensaje() {
        try {
            System.out.println("recibido");
            Socket conexionSocket = welcomeSocket.accept();
            DataInputStream recibido = new DataInputStream(conexionSocket.getInputStream());
            mensajeRecibido = recibido.readUTF();
//            int accion = Integer.parseInt(mensajeRecibido.substring((mensajeRecibido.length()-1), mensajeRecibido.length()));
//            mensajeRecibido = mensajeRecibido.substring(0, (mensajeRecibido.length()-1));
            System.out.println("Mensaje Recibido en el broker");
            brokerInstance.processRequest(mensajeRecibido);

        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Mensaje servidor" + excepcion.getMessage());
        }
    }

    //Revisarsi va aquí
    public void enviarMensaje() throws UnknownHostException, IOException {
        ClienteTCP protocolo = new ClienteTCP();
        protocolo.enviarMensaje(mensajeRecibido);
        
    }

    public void llamarAlServicio() throws FileNotFoundException, IOException {
        //revisar si va aquí proxyServidor


    }

    public static void main(String argv[]) throws Exception {
//        ServidorTCP servidorTCP = new ServidorTCP();
        Broker b = new Broker(new ClienteTCP());
       


        while (true) {
            b.getInSocket().recibirMensaje();
            b.getInSocket().enviarMensaje();
        }
    }
}
