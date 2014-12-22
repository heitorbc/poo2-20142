
package br.ifes.edu.poo2.cdp.Navios;

public class Graneleiro extends NavioCarga{
    
    public Graneleiro(){
        this.cargaMax=200;
        this.PassageiroMax=6;
    }
    
    private Graneleiro(Graneleiro g){
        this.PassageiroMax = g.PassageiroMax;
        this.cargaMax = g.cargaMax;
    }
     public double velocidadeMedia(double fator){
        return 20*fator -0.01*this.qtPassageiros - 0.3*this.qtCarga;
    }

    @Override
    public Navio clonar() {
        return new Graneleiro(this);
    }
    
}
