
package br.ifes.edu.poo2.cdp.localizacoes;

public class AguasProfundas extends ARota{
    public AguasProfundas(){
        this.fatorVelocidade = 4.8;
    }

    private AguasProfundas(AguasProfundas aThis) {
        this.fatorVelocidade = aThis.fatorVelocidade;
    }

    @Override
    public Localizacao clonar() {
        return new AguasProfundas(this);
    }

    

    
}
