/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.Candidato;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author user
 */
public class J {
    
    public static void main(String[] args) {
        Candidato candidato = new Candidato("Juan", "PAN");
        XStream xStream = new XStream(new DomDriver());
        String mensaje = xStream.toXML(candidato);
        System.out.println(mensaje);
        
        Candidato candidato1 = (Candidato)xStream.fromXML(mensaje);
        System.out.println(candidato1.getNombre());
        
        
    }
 
}
