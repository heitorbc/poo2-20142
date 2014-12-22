package br.ifes.edu.poo2.cdp.localizacoes;

import br.ifes.edu.poo2.cdp.Navios.Navio;
import java.util.ArrayList;

public abstract class ARota implements Localizacao{
    
    private Localizacao destino = new Porto();
    private int extensao;
    private int restricao;
    private ArrayList<Navio> navios = new ArrayList<>();
    protected double fatorVelocidade;
    
    public void removeNaviosDaRota()
    {
       for(int i=0; i<navios.size();i++)
       {
          if(navios.get(i).getDistanciaPercorrida()>=this.extensao)
          {
            navios.remove(i);
          }
       } 
    }
   
    public int getTotalPassageiros()
    {
        throw new UnsupportedOperationException("Nao Implementa aqui."); 
    }
    
    public int getExtensao() {
        return this.extensao;
    }

    public void setExtensao(int extensao) {
        this.extensao = extensao;
    }

    public int getRestricao() {
        return restricao;
    }

    public void setRestricao(int restricao) {
        this.restricao = restricao;
    }
    
    
    @Override
    public double fatorVelocidade(){
        return this.fatorVelocidade;
    }

    @Override
    public Localizacao proximoLocal() {
        return null;
    }

    @Override
    public boolean ehDestino() {
        return false;
    }
    
    public void setDestino(Localizacao porto){
        this.destino = porto;
    }
    
    public Localizacao getDestino(){
        return this.destino;
    }
    
    public void esvaziaPorto(){
       throw new UnsupportedOperationException("Nao Implementa aqui.");
    }
    
    public void setNumero(int numero) {
        throw new UnsupportedOperationException("Nao Implementa aqui."); 
    }

    
    public int getNumero() {
        throw new UnsupportedOperationException("Nao Implementa aqui."); 
    }

   
    public void setQtRotas(int quantidade) {
        throw new UnsupportedOperationException("Nao Implementa aqui."); 
    }

    
    public int getQtRotas() {
        throw new UnsupportedOperationException("Nao Implementa aqui.");
    }
    
    public void adicionaRota(Localizacao rota){
        throw new UnsupportedOperationException("Nao Implementa aqui.");
    }
    
    public ArrayList<Localizacao> getRotas(){
         throw new UnsupportedOperationException("Nao Implementa aqui.");
    }
    
    public void adicionaNavio(Navio navio) {
       this.navios.add(navio);
    }
    
    public ArrayList<Navio> getNavio(){
        return this.navios;
    }
}
