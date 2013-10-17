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


    }

    //Revisar la entrada de la variable
    public void convertirMensaje(String mensaje) {
        String mensajeRecibido;
//        Candidato candidato;
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        mensajeRecibido = xStream.toXML(mensaje);
       
//        Error de la conversión de xml a clase
         System.out.println((Candidato)xStream.fromXML(mensajeRecibido));
//        (Candidato)xStream.fromXML(mensajeRecibido);


        //Enviar a la vista
//
//        control.contabilizarVoto(candidato);
//        candidatos = control.darVotosContabilizados();
//        graficaBarras.actualizar(candidatos);




//        for (int i = 0; i < candidatos.size(); i++) {
//            System.out.println(candidatos.get(i).getNombre());
//            System.out.println(candidatos.get(i).getCantidadDeVotos());
//        }
    }
}