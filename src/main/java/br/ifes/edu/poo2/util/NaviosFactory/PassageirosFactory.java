
package br.ifes.edu.poo2.util.NaviosFactory;

import br.ifes.edu.poo2.cdp.Navios.Cruzeiro;
import br.ifes.edu.poo2.cdp.Navios.Escuna;
import br.ifes.edu.poo2.util.NaviosFactory.NavioFactory.tipoNavio;
import br.ifes.edu.poo2.cdp.Navios.Navio;

public class PassageirosFactory extends NavioFactory{
    private static final NavioFactory myfactory = new PassageirosFactory();
     private static final Cruzeiro cruzeiro = new Cruzeiro();
    private static final Escuna escuna = new Escuna();
    private PassageirosFactory(){
        
    }

    public static NavioFactory getPassageirosFactory(){
        return myfactory;
    }
        
    @Override
    protected Navio selectNavio(tipoNavio tipo) {
        if(tipo == tipoNavio.CRUZEIRO)
        {
            return cruzeiro.clonar();
        }
        else if(tipo == tipoNavio.ESCUNA)
        {
            return escuna.clonar();
        }
        throw new ExceptionInInitializerError("Navio desconhecido");
    }
}