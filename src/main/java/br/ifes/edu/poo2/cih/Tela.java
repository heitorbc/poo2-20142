/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.edu.poo2.cih;

import br.ifes.edu.poo2.cdp.Navios.Navio;
import br.ifes.edu.poo2.cdp.localizacoes.Localizacao;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Tela {
    /*public void listarPortos(ArrayList<Localizacao> portos){
         for(Localizacao p : portos)
        {
            System.out.print(p.getNumero() + ": " + p.getQtRotas() + " ");
            
                for(Localizacao r : p.getRotas())
            {
                System.out.print(r.getDestino().getNumero() + " ");
            }
            
            System.out.println();
        }
    }*/
    public void listarPortos(ArrayList<Localizacao> portos){
         for(Localizacao p : portos)
        {
            System.out.println(p.getNumero() + " " + p.getNavio().size());
        }
    }

    public void PrintDia(int i) {
        System.out.println("Dia: " + i + ".");
    }

    public void PrintPortosDestinos(ArrayList<Localizacao> portos) {
        for(Localizacao p : portos)
        {
            if(p.ehDestino()){
                System.out.println(p.getNumero());
                System.out.println("Quantidade de navios: " + p.getNavio().size());
                System.out.println("Quantidade de Passageiros: " + p.getTotalPassageiros());
                
            }
        }
    }
    
    public void printNavios(ArrayList<Navio> navios){
         System.out.println("Quantidade de navios: " + navios.size());
    }
}
