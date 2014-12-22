/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.edu.poo2.util.localizacoesFactory;

import br.ifes.edu.poo2.cdp.localizacoes.Localizacao;
import br.ifes.edu.poo2.cdp.localizacoes.Porto;

/**
 *
 * @author Gustavo
 */
public class PortoFactory extends LocalizacaoFactory{
    private static final LocalizacaoFactory myfactory = new PortoFactory();
    private static final Porto porto = new Porto();
    private PortoFactory(){
        
    }

    public static LocalizacaoFactory getPortoFactory(){
        return myfactory;
    }
    
    @Override
    protected Localizacao selectLocalizacao(tipoLocalizacao tipo){
        if(tipo == tipoLocalizacao.PORTO)
            return PortoFactory.porto.clonar();
        throw new ExceptionInInitializerError("Navio desconhecido");
    }
}
