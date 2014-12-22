
package br.ifes.edu.poo2.cdp.Navios;


public interface Navio {
    
    
    public double getDistanciaPercorrida();
    public void setDistanciaPercorrida(double d);
    public double velocidadeMedia(double fator);
    public double calculoMulta();
    public boolean destinoFinal();

    public void setPassageiros(int numero);

    public void setCarga(int RandomInt);

    public int getNumeroTipoNavio();

    public void addMulta();

    public int getQtPessoas();
    
    public Navio clonar();    
    
}
