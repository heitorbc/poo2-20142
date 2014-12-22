package br.ifes.edu.poo2.util.NaviosFactory;

import br.ifes.edu.poo2.cdp.Navios.CargaGeral;
import br.ifes.edu.poo2.util.NaviosFactory.NavioFactory.tipoNavio;
import br.ifes.edu.poo2.cdp.Navios.Graneleiro;
import br.ifes.edu.poo2.cdp.Navios.Navio;

public class CargaFactory extends NavioFactory{
    private static final NavioFactory myfactory = new CargaFactory();
    private static final Graneleiro graneleiro = new Graneleiro();
    private static final CargaGeral cargaGeral = new CargaGeral();
    private CargaFactory(){
        
    }

    public static NavioFactory getCargaFactory(){
        return myfactory;
    } 
    
    protected Navio selectNavio(tipoNavio tipo) {
        if(tipo == tipoNavio.GRANELEIRO)
        {
            return graneleiro.clonar();
        }
        else if(tipo == tipoNavio.CARGA_GERAL)
        {
            return cargaGeral.clonar();
        }
        throw new ExceptionInInitializerError("Navio desconhecido");
    }
}
