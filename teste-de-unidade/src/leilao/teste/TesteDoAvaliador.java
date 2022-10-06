package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TesteDoAvaliador {

     @Test
     public void deveEntenderLancesEmOrdemCrescente() {
          Usuario joao = new Usuario("João");
          Usuario jose = new Usuario("José");
          Usuario maria = new Usuario("Maria");

          Leilao leilao = new Leilao("Playstation 3 Novo");

          leilao.propoe(new Lance(joao, 250));
          leilao.propoe(new Lance(jose, 300));
          leilao.propoe(new Lance(maria, 400));

          Avaliador leiloeiro = new Avaliador();
          leiloeiro.avalia(leilao);

          double maiorEsperado = 400;
          double menorEsperado = 250;

          System.out.println(leiloeiro.getMaiorLance());
          assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
          System.out.println(leiloeiro.getMenorLance());
          assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
     }
     @Test
     public void deveEntenderLeilaoComApenasUmLance(){
          Usuario joao = new Usuario("João");
          Leilao leilao = new Leilao("Playstation 3 Novo");

          leilao.propoe(new Lance(joao, 1000));

          Avaliador leiloeiro = new Avaliador();

          leiloeiro.avalia(leilao);

          assertEquals(1000, leiloeiro.getMaiorLance(), 0.00001);
          assertEquals(1000, leiloeiro.getMenorLance(), 0.00001);

     }
     @Test
     public void deveEncontrarOsTresMaioresLances(){
          Usuario joao = new Usuario("Joao");
          Usuario maria = new Usuario("Maria");
          Leilao leilao = new Leilao("Playstation 3 Novo");

          leilao.propoe(new Lance(joao, 100));
          leilao.propoe(new Lance(maria, 200));
          leilao.propoe(new Lance(joao, 300));
          leilao.propoe(new Lance(maria, 400));

          Avaliador leiloeiro = new Avaliador();
          leiloeiro.avalia(leilao);

          List<Lance> maiores = leiloeiro.getTresMaiores();
          assertEquals(3, maiores.size());
          assertEquals(400, maiores.get(0).getValor(), 0.00001);
          assertEquals(300, maiores.get(1).getValor(), 0.00001);
          assertEquals(200, maiores.get(2).getValor(), 0.00001);


     }
}
