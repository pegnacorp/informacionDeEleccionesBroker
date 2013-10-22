/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ControaladorServidor {

    private ArrayList<Candidato> candidatos;
    private ContabilizadorDeVotos contabilizadorDeVotos;
    

    public ControaladorServidor() {
        candidatos = new ArrayList<Candidato>();
        Candidato candidato1 = new Candidato("Maximiliano de Hadsburgo", "Conservadores");
        Candidato candidato2 = new Candidato("Benito Juarez", "Liberales");
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        contabilizadorDeVotos = new ContabilizadorDeVotos(candidatos);
        
    }
    public ArrayList<Candidato> darVotosContabilizados(){
        return contabilizadorDeVotos.getDarVotaciones();
    }

    public void contabilizarVoto(Candidato candidato) {
        contabilizadorDeVotos.contabilizar(candidato);
        
    }

}
