/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.Candidato;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ControaladorServidor {

    private ArrayList<Candidato> candidatos;
    private ContabilizadorDeVotos contabilizadorDeVotos;
    private GraficaBarras graficaBarras;

    public ControaladorServidor() {
        candidatos = new ArrayList<Candidato>();
        Candidato candidato1 = new Candidato("Maximiliano de Hadsburgo", "Conservadores");
        Candidato candidato2 = new Candidato("Benito Juárez", "Liberales");
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
