
package br.ifes.edu.poo2.cdp.Navios;

import br.ifes.edu.poo2.cdp.localizacoes.Localizacao;

public abstract class ANavio implements Navio {

    private int numeroTipoNavio;
    protected Localizacao local;
    private double distanciaPercorrida;
    protected int qtPassageiros;
    private int velocidade;
    private double multa;
    protected int PassageiroMax;

    public abstract double velocidadeMedia(double fator);
    
    public int getQtPessoas(){
        return this.qtPassageiros;
    }
    public int getNumeroTipoNavio() {
        return numeroTipoNavio;
    }

    public void setNumeroTipoNavio(int numeroTipoNavio) {
        this.numeroTipoNavio = numeroTipoNavio;
    }
    
   
    public void setPassageiros(int numero){
        this.qtPassageiros=numero;
    }
    
    public double getDistanciaPercorrida(){
        return this.distanciaPercorrida;
    }
    
    public void setDistanciaPercorrida(double distancia){
        if(distancia>0)
        this.distanciaPercorrida=this.distanciaPercorrida+distancia;   
        else
            this.distanciaPercorrida=0;
    }
    
    public double calculoMulta(){
        System.out.println("Nao implementado ainda");
        return 1.1;
    }
    
    public void addMulta()
    {
        this.multa++;
    }
    
    public boolean destinoFinal(){
        System.out.println("Nao implementado ainda");
        return false;
    }
    
    public abstract Navio clonar();
}
