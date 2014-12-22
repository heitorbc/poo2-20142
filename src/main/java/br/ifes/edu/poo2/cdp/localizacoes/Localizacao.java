package br.ifes.edu.poo2.cdp.localizacoes;

import br.ifes.edu.poo2.cdp.Navios.Navio;
import java.util.ArrayList;

public interface Localizacao {
    
    public double fatorVelocidade();
    
    public Localizacao proximoLocal();
    public boolean ehDestino();
    
    public void setNumero(int numero);
    public int getNumero();

    public void setQtRotas(int quantidade);
    public int getQtRotas();

    public void setDestino(Localizacao get);
    public Localizacao getDestino();

    public void adicionaRota(Localizacao rota);

    public void setExtensao(int extensao);

   // public void setTipo(int tipo);

    public void setRestricao(int restricoes);

   // public Iterable<Localizacao> getRotas();


    public void adicionaNavio(Navio navio);

    public ArrayList<Localizacao> getRotas();

    public ArrayList<Navio> getNavio();

    public void esvaziaPorto();
    
    public int getRestricao();

    public int getExtensao();

    public void removeNaviosDaRota();

    public int getTotalPassageiros();
    
    public Localizacao clonar();

}
