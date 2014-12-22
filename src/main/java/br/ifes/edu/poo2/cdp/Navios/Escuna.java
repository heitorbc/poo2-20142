
package br.ifes.edu.poo2.cdp.Navios;


public class Escuna extends ANavio {
     public Escuna(){
        this.PassageiroMax=20;
    }
     
    private Escuna(Escuna c){
         this.PassageiroMax = c.PassageiroMax;
    }
    
     public double velocidadeMedia(double fatorVelocidade){
        return (22*fatorVelocidade-0.6*this.qtPassageiros);
     }

    @Override
    public void setCarga(int RandomInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    @Override
    public Navio clonar() {
        return new Escuna(this);
    }
    
}
