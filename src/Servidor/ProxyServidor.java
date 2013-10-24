package Servidor;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ProxyServidor {

    private String mensaje;
    private XStream xStream = new XStream(new DomDriver());
    private ControaladorServidor control;
    private GraficaBarras graficaBarras;
    private ArrayList<Candidato> candidatos;
    private Candidato candidato;
    private boolean validarMensaje;

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
        int accion = Integer.parseInt(mensaje.substring((mensaje.length() - 1), mensaje.length()));
        mensaje = mensaje.substring(0, (mensaje.length() - 1));


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


        //        for (int i = 0; i < candidatos.size(); i++) {
//            System.out.println(candidatos.get(i).getNombre());
//            System.out.println(candidatos.get(i).getCantidadDeVotos());
//        }
    }

    private void enviarValidacionMensaje(boolean estadoMensaje) throws UnknownHostException, IOException {
        ClienteTCP clienteTCP = new ClienteTCP();
        if (estadoMensaje) {
            clienteTCP.enviarMensaje("1");
        } else {
            clienteTCP.enviarMensaje("0");
        }
    }

    public void processRequest(int accion, Candidato c) throws UnknownHostException, IOException {
        switch (accion) {
            case 1:
                control.contabilizarVoto(candidato);
                candidatos = control.darVotosContabilizados();
                graficaBarras.actualizar(candidatos);
                enviarValidacionMensaje(true);

                break;
            default:
                enviarValidacionMensaje(false);

        }
    }
}