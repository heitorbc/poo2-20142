
package br.ifes.edu.poo2.cdp.localizacoes;

import br.ifes.edu.poo2.cdp.Navios.Navio;
import java.util.ArrayList;

public abstract class APorto implements Localizacao{
    
    private int numero;
    private int qtRotas;
    private boolean ehDestino;
    private ArrayList<Localizacao> rotas;
    private ArrayList<Navio> navios = new ArrayList<>();
    private int totalPassageiros;
    protected final double fatorVelocidade;
    
    public int getTotalPassageiros(){
        for(Navio n: navios)
        {
            this.totalPassageiros = this.totalPassageiros + n.getQtPessoas();
        }
        return this.totalPassageiros;
    }
    
    public void esvaziaPorto(){
        this.navios.clear();
    }
    public void adicionaNavio(Navio navio){
        this.navios.add(navio);
    }
    
    public ArrayList<Navio> getNavio(){
        return this.navios;
    }
    
     public abstract double fatorVelocidade();
    
     
    public APorto() {
        this.rotas = new ArrayList<>();
        this.fatorVelocidade = 0;/*Pois a velocidade no porto eh 0*/
    }
  
    
    public ArrayList<Localizacao> getRotas(){
        return this.rotas;
    }
   
    
    @Override
    public Localizacao proximoLocal() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean ehDestino() {
        return this.qtRotas==0;
    }
    
    public void adicionaRota(Localizacao rota){
        this.rotas.add(rota);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtRotas() {
        return qtRotas;
    }

    public void setQtRotas(int qtRotas) {
        this.qtRotas = qtRotas;
    }

    public boolean isEhDestino() {
        return ehDestino;
    }

    public void setEhDestino(boolean ehDestino) {
        this.ehDestino = ehDestino;
    }
    
    public void setDestino(Localizacao get){
        throw new UnsupportedOperationException("Nao implementa.");
    }
    public Localizacao getDestino(){
        throw new UnsupportedOperationException("Nao implementa.");
    }
    
    public void setRestricao(int l){
        throw new UnsupportedOperationException("Nao implementa.");
    }
    
    public  int getRestricao(){
        throw new UnsupportedOperationException("Nao implementa.");
    }
    
     public void removeNaviosDaRota(){
         throw new UnsupportedOperationException("Nao implementa.");
     }
    public void setExtensao(int extensao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
