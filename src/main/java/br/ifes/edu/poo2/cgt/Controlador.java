package br.ifes.edu.poo2.cgt;

import br.ifes.edu.poo2.cgd.ArquivoRotas;
import br.ifes.edu.poo2.util.NaviosFactory.CargaFactory;
import br.ifes.edu.poo2.util.NaviosFactory.NavioFactory;
import br.ifes.edu.poo2.util.NaviosFactory.PassageirosFactory;
import br.ifes.edu.poo2.cdp.Navios.Navio;
import br.ifes.edu.poo2.cdp.localizacoes.Localizacao;
import br.ifes.edu.poo2.cih.Tela;
import br.ifes.edu.poo2.util.random.Randomico;
import java.util.ArrayList;

public class Controlador {

    private ArrayList<Localizacao> portos = new ArrayList<>();
    private Randomico random = Randomico.getInstance();
    private int numeroRandomico;
    ArrayList<Navio> navios = new ArrayList<>();

    public void iniciarControlador(String dias) throws Exception {
        int numeroDias = Integer.parseInt(dias);
        Tela novaTela = new Tela();
        ArquivoRotas novoArq = new ArquivoRotas();
        portos = novoArq.lerArquivo("Rotas.txt"); /*Retorna os portos com as rotas inseridas*/
        for (int i = 0; i <= numeroDias; i++) {
            novaTela.PrintDia(i);

            alocarNavioPassageiro(Randomico.RandomInt(0, 2), Randomico.RandomInt(0, 500), NavioFactory.tipoNavio.CRUZEIRO);
            alocarNavioPassageiro(Randomico.RandomInt(0, 5), Randomico.RandomInt(0, 20), NavioFactory.tipoNavio.ESCUNA);

            alocarNavioCarga(Randomico.RandomInt(0, 3), Randomico.RandomInt(0, 12), Randomico.RandomInt(0, 150), NavioFactory.tipoNavio.CARGA_GERAL);
            alocarNavioCarga(Randomico.RandomInt(0, 2), Randomico.RandomInt(0, 6), Randomico.RandomInt(0, 200), NavioFactory.tipoNavio.GRANELEIRO);
            if (i > 0) {
                ColocarNaviosNasRotas();/*retire os navios dos portos e determine qual rota ele vai tomar
                 e coloque o navio na rota.*/

                novaTela.printNavios(navios);
                andarNavios();/*para todas as rotas atualize a posição do navio na rota.*/
               // verificaRotas();/*Se um navio chegou ao fim da rota, retire-o da rota e coloque na fila do porto de destino.*/
            }
        }
        novaTela.PrintPortosDestinos(portos);
        novaTela.printNavios(navios);
    }
    
    public void alocarNavioPassageiro(int qtNavio, int qtPassageiros, NavioFactory.tipoNavio tipo){
        NavioFactory fabricaNavios = PassageirosFactory.getPassageirosFactory();    
        for (int j = 0; j < qtNavio; j++) {
                Navio navio = fabricaNavios.build(tipo);
                navio.setPassageiros(qtPassageiros);//Adiciona um numero randomico de passageiros.
                portos.get(0).adicionaNavio(navio); //Adicional navio a lista de Navios do porto de origem.
                navios.add(navio);//Adiciona o navio a lista de navios.
            }
            
    }

    private void alocarNavioCarga(int qtNavio, int qtpassageiros, int qtcarga, NavioFactory.tipoNavio tipoNavio) {
        NavioFactory fabricaNavios = CargaFactory.getCargaFactory();
        for (int j = 0; j < qtNavio; j++) {
                Navio navio = fabricaNavios.build(tipoNavio);
                navio.setPassageiros(qtpassageiros);//Adiciona um numero randomico de passageiros.
                navio.setCarga(qtcarga);
                portos.get(0).adicionaNavio(navio); //Adicional navio a lista de Navios do porto de origem.
                navios.add(navio);//Adiciona o navio a lista de navios.
            }
    }
    
    public void verificaRotas() {
        for (Localizacao p : portos) {
            if (!p.ehDestino()) {
                for (Localizacao r : p.getRotas()) {
                    r.removeNaviosDaRota();
                }
            }
        }
    }

    public void andarNavios() {
        for (int i = 0; i < portos.size(); i++) {
            if (!portos.get(i).ehDestino()) {
                for (int j = 0; j < portos.get(i).getRotas().size(); j++) {
                    for (int k = 0; k < portos.get(i).getRotas().get(j).getNavio().size(); k++) {
                        if (portos.get(i).getRotas().get(j).getNavio().get(k).getNumeroTipoNavio() != portos.get(i).getRotas().get(j).getRestricao()) {
                            portos.get(i).getRotas().get(j).getNavio().get(k).addMulta();
                        }
                        portos.get(i).getRotas().get(j).getNavio().get(k).setDistanciaPercorrida(portos.get(i).getRotas().get(j).getNavio().get(k).velocidadeMedia(portos.get(i).getRotas().get(j).fatorVelocidade()) * 12);

                        /*se a exntensao for menor o navio chegou ao porto destino e deve ficar ate o dia seguinte*/
                        if (portos.get(i).getRotas().get(j).getNavio().get(k).getDistanciaPercorrida() >= portos.get(i).getRotas().get(j).getExtensao()) {
                            /*Adiciona o Navio ao porto destino*/
                            portos.get(i).getRotas().get(j).getDestino().adicionaNavio(portos.get(i).getRotas().get(j).getNavio().get(k));
                            portos.get(i).getRotas().get(j).getNavio().remove(k);
                            //tem que remover o navio da rota!!!!
                            //criar aqui algo pra tirar ele.
                        }
                    }

                }

            }

        }

    }

    public void ColocarNaviosNasRotas() throws Exception {

        /*Retirar os Navios dos portos e decidir a rota que ele vai tomar*/
        for (Localizacao p : portos) {
            if (!p.ehDestino()) {
                for (Navio n : p.getNavio()) {
                    /*coloco os navios nas rotas*/
                    numeroRandomico = Randomico.RandomInt(0, (p.getQtRotas() - 1));

                    n.setDistanciaPercorrida(-1);
                    p.getRotas().get(numeroRandomico).adicionaNavio(n);

                }
                /*Limpo a lista de navios do porto*/
                p.esvaziaPorto();
            }
        }
    }

    
}
