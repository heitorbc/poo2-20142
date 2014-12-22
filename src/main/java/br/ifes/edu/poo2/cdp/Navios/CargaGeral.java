
package br.ifes.edu.poo2.cdp.Navios;


public class CargaGeral extends NavioCarga {
    
    public CargaGeral(){
        this.PassageiroMax=12;
        this.cargaMax=150;
    }
    
    public CargaGeral(CargaGeral c){
        this.PassageiroMax = c.PassageiroMax;
        this.cargaMax = c.cargaMax;
    }
    
    public double velocidadeMedia(double fator){
        return 22*fator-0.01*this.qtPassageiros -0.4*this.qtCarga;
    }

    @Override
    public Navio clonar() {
        return new CargaGeral(this);
    }
        
    
}
