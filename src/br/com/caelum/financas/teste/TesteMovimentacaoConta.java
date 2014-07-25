package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.JPAUtil.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteMovimentacaoConta {

    public static void main(final String[] args) {
        final EntityManager manager = new JPAUtil().getEntityManager();
        // final Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
        // System.out.println("Titulo da Conta: " + movimentacao.getConta().getTitular());
        // final Conta conta = manager.find(Conta.class, 10);
        // System.out.println(conta.getMovimentacao().size());
        final Query query = manager.createQuery("select c from Conta c");

        final List<Conta> contas = query.getResultList();

        for (final Conta conta : contas) {
            System.out.println("Numero de movimentaçoes: " + conta.getMovimentacao().size());
        }
    }

}
