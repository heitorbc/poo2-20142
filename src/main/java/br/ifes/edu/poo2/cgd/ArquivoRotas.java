package br.ifes.edu.poo2.cgd;

import br.ifes.edu.poo2.cdp.localizacoes.APorto;
import br.ifes.edu.poo2.cdp.localizacoes.Localizacao;
import br.ifes.edu.poo2.cdp.localizacoes.Porto;
import br.ifes.edu.poo2.util.localizacoesFactory.LocalizacaoFactory;
import static br.ifes.edu.poo2.util.localizacoesFactory.LocalizacaoFactory.tipoLocalizacao.AGUASPROFUNDAS;
import static br.ifes.edu.poo2.util.localizacoesFactory.LocalizacaoFactory.tipoLocalizacao.PORTO;
import br.ifes.edu.poo2.util.localizacoesFactory.PortoFactory;
import br.ifes.edu.poo2.util.localizacoesFactory.RotaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ArquivoRotas {
    
    private int numeroDePortos;
    private int numeroDeRotas;
    private int numeroDeDestinos;
    
    public ArrayList<Localizacao> portos = new ArrayList<>();
    LocalizacaoFactory fabricaLocalizacoes;
    //private Object porto;
   // private Object rotas;
    
    public ArrayList<Localizacao> lerArquivo(String nome)
    {    
        try
        {
            Scanner scn = new Scanner(new File(nome));//Abre, especifica o arquivo a ser lido.	 
            System.out.println("Lendo Arquivo...");
            lerQuantidades(scn);
            criarLocalizacoes(scn);
            while(scn.hasNext())
            {
                criarNavios(scn);
            }
            
	}
	catch(FileNotFoundException ioe)
	{  
            ioe.printStackTrace();
	}  
        
        return this.portos;
    }
    
    private void lerQuantidades(Scanner scn){
        String primeiraLinha;
        primeiraLinha = scn.next();  //Le o primeiro Numero
        this.numeroDePortos = Integer.parseInt(primeiraLinha); //Atribui o numero de Portos
        primeiraLinha = scn.next();
        this.numeroDeRotas = Integer.parseInt(primeiraLinha);
        primeiraLinha = scn.next();
        this.numeroDeDestinos = Integer.parseInt(primeiraLinha);
    }

    private void criarLocalizacoes(Scanner scn) {
        for(int i=0; i<numeroDePortos; i++) //Le todos os portos Para salvar scn.hasNext()
            {
                String numeroDoPorto = scn.next();
                int numero = Integer.parseInt(numeroDoPorto);
                String quantidadeDeRotas = scn.next(); //pega a quantidade de rotas que o porto possui
                int quantidade = Integer.parseInt(quantidadeDeRotas);//Transformo para interio
                //usando o metodo fabrica
                fabricaLocalizacoes = PortoFactory.getPortoFactory();
                Localizacao local = fabricaLocalizacoes.build(LocalizacaoFactory.tipoLocalizacao.PORTO);
                local.setNumero(numero);
                local.setQtRotas(quantidade);
                portos.add(local);
              
            }
    }
    
    private void criarNavios(Scanner scn){
        String PortoOrigem = scn.next();
                int origem = Integer.parseInt(PortoOrigem);
                String PortoDestino = scn.next();
                int destino = Integer.parseInt(PortoDestino);
                String extensaoDaRota = scn.next();
                int extensao = Integer.parseInt(extensaoDaRota);
                String tipoRota = scn.next();
                int tipo = Integer.parseInt(tipoRota);
                String retricoesDeRota = scn.next();
                int restricoes = Integer.parseInt(retricoesDeRota);
                fabricaLocalizacoes = RotaFactory.getRotaFactory();
                Localizacao rota = null;
                if(tipo==1){
                    rota = fabricaLocalizacoes.build(LocalizacaoFactory.tipoLocalizacao.AGUASPROFUNDAS);
                }else if(tipo==2){
                    rota = fabricaLocalizacoes.build(LocalizacaoFactory.tipoLocalizacao.LITORANEA);
                }else if(tipo==3){
                    rota = fabricaLocalizacoes.build(LocalizacaoFactory.tipoLocalizacao.TRANSCONTINENTAL);
                }
                if(rota!=null && portos!=null){
                    rota.setDestino(portos.get(destino));
                    rota.setExtensao(extensao);
                    //rota.setTipo(tipo);
                    rota.setRestricao(restricoes);           
                    portos.get(origem).adicionaRota(rota);
                }
    }
}