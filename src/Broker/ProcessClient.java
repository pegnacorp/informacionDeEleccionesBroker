/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import Cliente.Cliente;
//import Servidor.Candidato;


/**
 *
 * @author Asus
 */
public class ProcessClient implements Runnable{
    Cliente cliente;
    public ProcessClient(Cliente cliente){
        this.cliente = cliente;
//        start();
    }
    
    @Override
    public void run() {
        while(true){
            System.out.println(cliente);
        }
    
    }
    
    
    
}
