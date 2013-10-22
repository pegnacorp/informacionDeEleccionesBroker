package Servidor;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

    public void recibirMensaje(String mensaje) throws FileNotFoundException, IOException {
        this.mensaje = mensaje;
        convertirMensaje(mensaje);


    }

    //Revisar la entrada de la variable
    public void convertirMensaje(String mensaje) throws FileNotFoundException, IOException {
        String mensajeRecibido;
//        Candidato candidato;
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        mensajeRecibido = xStream.toXML(mensaje);

//        Error de la conversión de xml a clase

        File xmlFile = new File("model.xml");
        xStream.fromXML(new FileInputStream(xmlFile));

        XStream xstream = new XStream();
        xstream.useAttributeFor(String.class);
        xstream.useAttributeFor(Integer.class);

        Writer writer = new FileWriter(xmlFile);
        writer.write(xstream.toXML(xmlFile));
        writer.close();

        System.out.println((Candidato) xStream.fromXML(mensajeRecibido.substring(1)));

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