
package br.ifes.edu.poo2.cdp.Navios;


public abstract class NavioCarga extends ANavio {
    
    protected int cargaMax;
    protected int qtCarga;
    
    public int getQtCarga() {
        return qtCarga;
    }

    public void setCarga(int qtCarga) {
        this.qtCarga = qtCarga;
    }

    @Override
    public double velocidadeMedia(double fator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    
}
