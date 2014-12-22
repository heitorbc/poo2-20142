package br.ifes.edu.poo2.cdp.localizacoes;

public class Porto extends APorto {
    
    public Porto(){
        
    }
    
    private Porto(Porto p){
        
    }
    
    
    @Override
    public double fatorVelocidade(){
       return this.fatorVelocidade; 
   } 

    @Override
    public int getExtensao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Localizacao clonar() {
        return new Porto(this);
    }
    
}
