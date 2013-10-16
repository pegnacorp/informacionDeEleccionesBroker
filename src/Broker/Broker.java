package Broker;

import Cliente.Cliente;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Broker {
    private ArrayList<ProcessClient> processors;
    
    public Broker(){
        processors = new ArrayList<ProcessClient>();
    }
    
    public void createClientThread(Cliente cliente){
       processors.add(new ProcessClient(cliente));
    }
    
    
    /*
     * outputs the available server instructions
     */
    public void getAvailableInstructions(){
        
    }
}
