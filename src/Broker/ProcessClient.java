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
        
    }
    
    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("wait for actions :D");
    }
    
    
    
}
