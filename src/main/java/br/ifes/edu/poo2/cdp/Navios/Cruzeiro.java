
package br.ifes.edu.poo2.cdp.Navios;


public class Cruzeiro extends ANavio{
    public Cruzeiro(){
        this.PassageiroMax=500;
    }
    
    private Cruzeiro(Cruzeiro c){
         this.PassageiroMax = c.PassageiroMax;
    }
    
     public double velocidadeMedia(double fator){
        return 36*fator -0.2*this.qtPassageiros;
    }

    @Override
    public void setCarga(int RandomInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Navio clonar() {
        return new Cruzeiro(this);
    }

    
        
}
