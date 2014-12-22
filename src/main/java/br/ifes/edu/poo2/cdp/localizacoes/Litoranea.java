package br.ifes.edu.poo2.cdp.localizacoes;

public class Litoranea extends ARota{
    
    public Litoranea(){
        this.fatorVelocidade = 4;
    }

    private Litoranea(Litoranea aThis) {
        this.fatorVelocidade = aThis.fatorVelocidade;
    }

    @Override
    public Localizacao clonar() {
        return new Litoranea(this);
    }
}
