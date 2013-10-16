package Servidor;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;

public class ProxyServidor {

    private String mensaje;
    private XStream xStream = new XStream(new DomDriver());
    
    private ControaladorServidor control;
    private GraficaBarras graficaBarras;

    public ProxyServidor() {
        control = new ControaladorServidor();
        graficaBarras = new GraficaBarras();
        graficaBarras.setVisible(true);
    }

    public void recibirMensaje(String mensaje) {
        this.mensaje = mensaje;
        convertirMensaje(mensaje);

//        System.out.println(xStream.toXML(mensaje)); Cóidgo para imprimirlo en xml

    }

    //Revisar la entrada de la variable
    public void convertirMensaje(String mensaje) {
        Candidato candidato;
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        candidato = (Candidato) xStream.fromXML(mensaje);


        //Enviar a la vista

        control.contabilizarVoto(candidato);
        candidatos = control.darVotosContabilizados();
        graficaBarras.actualizar(candidatos);
        



//        for (int i = 0; i < candidatos.size(); i++) {
//            System.out.println(candidatos.get(i).getNombre());
//            System.out.println(candidatos.get(i).getCantidadDeVotos());
//        }
    }
}