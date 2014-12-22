package br.ifes.edu.poo2.cdp.localizacoes;

public class Transcontinental extends ARota{
    public Transcontinental()
    {
        this.fatorVelocidade = 5;
    }  

    private Transcontinental(Transcontinental aThis) {
        this.fatorVelocidade = aThis.fatorVelocidade;
    }

    @Override
    public Localizacao clonar() {
        return new Transcontinental(this);
    }
}
