package br.ifes.edu.poo2.util.NaviosFactory;

import br.ifes.edu.poo2.cdp.Navios.Navio;

public abstract class NavioFactory {
    public enum tipoNavio {CRUZEIRO, ESCUNA, GRANELEIRO, CARGA_GERAL}
    
    public Navio build(tipoNavio tipo){
        Navio local = selectNavio(tipo);
        return local;
    }
    
    protected abstract Navio selectNavio(tipoNavio tipo);
}
