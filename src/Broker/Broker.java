package Broker;

import Cliente.Cliente;
import Servidor.Candidato;
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

//    public Broker(ClienteTCP client) throws IOException {
//        inSocket = new ServidorTCP(this);
//        outSocket = client;
//    }

    public void createClientSocket(Cliente cliente) {
        Thread clientThread = new Thread(new ProcessClient(cliente));
        processors.add(clientThread);
        clientThread.start();
    }

    public void processRequest(String xmlObject) throws IOException {
//        outSocket.enviarMensaje(xmlObject);
        enviarValidacionMensaje(true);
        
//        eleccionServicio(accion);
        outSocket.enviarMensaje(xmlObject);
    }

    /*
     * outputs the available server instructions
     */
    public void getAvailableInstructions() {
    }

    public ServidorTCP getInSocket() {
        return inSocket;
    }

    public ClienteTCP getOutSocket() {
        return outSocket;
    }

    private void enviarValidacionMensaje(boolean estadoMensaje) throws UnknownHostException, IOException {
        Servidor.ClienteTCP clienteTCP = new Servidor.ClienteTCP();
        if (estadoMensaje) {
            clienteTCP.enviarMensaje("1");
        } else {
            clienteTCP.enviarMensaje("0");
        }
    }

    public void eleccionServicio(int accion) {
        switch (accion) {
            case 1:
                break;
            default:
                

        }

    }
}
