/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.edu.poo2.util.localizacoesFactory;

import br.ifes.edu.poo2.cdp.localizacoes.Localizacao;

/**
 *
 * @author Gustavo
 */
public abstract class LocalizacaoFactory {
    public enum tipoLocalizacao {PORTO, LITORANEA, TRANSCONTINENTAL, AGUASPROFUNDAS}
    
    public Localizacao build(tipoLocalizacao tipo){
        Localizacao local = selectLocalizacao(tipo);
        return local;
    }
    
    protected abstract Localizacao selectLocalizacao(tipoLocalizacao tipo);
    
}
