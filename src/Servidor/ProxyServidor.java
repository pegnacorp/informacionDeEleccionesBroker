package Servidor;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ProxyServidor {

    private String mensaje;
    private XStream xStream = new XStream(new DomDriver());
    private ControaladorServidor control;
    private GraficaBarras graficaBarras;
    private ArrayList<Candidato> candidatos;

    public ProxyServidor() {
        control = new ControaladorServidor();
        candidatos = new ArrayList<Candidato>();
        graficaBarras = new GraficaBarras();
        graficaBarras.setVisible(true);
    }

    public void recibirMensaje(String mensaje) throws FileNotFoundException, IOException {
        this.mensaje = mensaje;
        convertirMensaje(mensaje);
    }

    //Revisar la entrada de la variable
    public void convertirMensaje(String mensaje) throws FileNotFoundException, IOException {
//        String mensajeRecibido;
        Candidato candidato;
        int accion = Integer.parseInt(mensaje.substring((mensaje.length()-1), mensaje.length()));
        mensaje = mensaje.substring(0, (mensaje.length()-1));


//        Candidato candidato;
//        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        xStream.alias("candidato", Candidato.class);
        candidato = (Candidato) xStream.fromXML(mensaje);
        System.out.println("Candidato" + candidato.getNombre());
        processRequest(accion, candidato);
//        Error de la conversión de xml a clase
//


//        System.out.println((Candidato) xStream.fromXML(mensajeRecibido.substring(1)));

//        (Candidato)xStream.fromXML(mensajeRecibido);


        //Enviar a la vista


        control.contabilizarVoto(candidato);
        candidatos = control.darVotosContabilizados();
        graficaBarras.actualizar(candidatos);




//        for (int i = 0; i < candidatos.size(); i++) {
//            System.out.println(candidatos.get(i).getNombre());
//            System.out.println(candidatos.get(i).getCantidadDeVotos());
//        }
    }
    
    public void processRequest(int accion, Candidato c){
        switch(accion){
            case 1:
                System.out.println("acciom 1");
                break;
            default:
                System.out.println("aqui estaria la ccion 2");
        }
    }
}