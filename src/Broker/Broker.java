package Broker;

import Cliente.Cliente;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Broker {
    private ArrayList<Thread> processors;
    private ServidorTCP inSocket;
    private ClienteTCP outSocket;
    
    public Broker(ClienteTCP client) throws IOException{
        inSocket = new ServidorTCP(this);
        outSocket = client;
    }
    
    public void createClientSocket(Cliente cliente){
        Thread clientThread = new Thread(new ProcessClient(cliente));
        processors.add(clientThread);
        clientThread.start();
    }
    
    public void processRequest(String xmlObject) throws IOException{
        outSocket.enviarMensaje(xmlObject);
    }
    
    
    /*
     * outputs the available server instructions
     */
    public void getAvailableInstructions(){
        
    }


    public ServidorTCP getInSocket() {
        return inSocket;
    }

    public ClienteTCP getOutSocket() {
        return outSocket;
    }
}
