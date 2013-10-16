/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;


/**
 *
 * @author user
 */
public class Candidato {
    private String nombre;
    private String partidoPolitico;
    private int cantidadDeVotos;

    public Candidato(String nombre, String partidoPolitico) {
        this.nombre = nombre;
        this.partidoPolitico = partidoPolitico;
        cantidadDeVotos = 0;
    }

    public int getCantidadDeVotos() {
        return cantidadDeVotos;
    }

    public void setCantidadDeVotos(int candidadDeVotos) {
        this.cantidadDeVotos = candidadDeVotos;
    }

    public String getNombre() {
        return nombre;
    }


    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    
    
    
    
}
