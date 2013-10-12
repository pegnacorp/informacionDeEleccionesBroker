package Cliente;
import Servidor.*;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ProxyCliente {

    private Candidato candidato;
    private String mensaje;
    private ProxyServidor proxyServidor;

    public ProxyCliente() {
        proxyServidor = new ProxyServidor();
    }
    public void recibirMensaje(Candidato candidato){
        this.candidato = candidato;
        
    }


    /**Método que traducirá lo enviado en un xml*/
    public void empaquetarDatos() {
        XStream xStream = new XStream(new DomDriver());
        mensaje = xStream.toXML(candidato);
        
    }
    /**Método que traducirá lo recibido en una clase*/
    public void desempaquetarDatos(){
        
    }
    /**Método que enviará el mensaje al servidor 
     
     */
    public void enviarMensaje(){
        
        proxyServidor.recibirMensaje(mensaje);
    }

}