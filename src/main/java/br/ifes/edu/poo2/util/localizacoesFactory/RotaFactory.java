/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.edu.poo2.util.localizacoesFactory;

import br.ifes.edu.poo2.cdp.localizacoes.AguasProfundas;
import br.ifes.edu.poo2.cdp.localizacoes.Litoranea;
import br.ifes.edu.poo2.cdp.localizacoes.Localizacao;
import br.ifes.edu.poo2.cdp.localizacoes.Transcontinental;

/**
 *
 * @author Gustavo
 */
public class RotaFactory extends LocalizacaoFactory{
    private static final LocalizacaoFactory myfactory = new RotaFactory();
    private static final Litoranea litoranea = new Litoranea();
    private static final AguasProfundas aguasProfundas = new AguasProfundas();
    private static final Transcontinental transcontinental = new Transcontinental();
    
    public static LocalizacaoFactory getRotaFactory(){
        return myfactory;
    }
    
    @Override
    protected Localizacao selectLocalizacao(tipoLocalizacao tipo) {
        if(tipo == tipoLocalizacao.LITORANEA)
            return RotaFactory.litoranea.clonar();
        if(tipo == tipoLocalizacao.TRANSCONTINENTAL)
            return RotaFactory.transcontinental.clonar();
        else if(tipo == tipoLocalizacao.AGUASPROFUNDAS)
            return RotaFactory.aguasProfundas.clonar();
        throw new ExceptionInInitializerError("Navio desconhecido");
    }
    
}
