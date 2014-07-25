package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import JPAUtil.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TesteConsulta {
    public static void main(final String[] args) {
        final EntityManager manager = new JPAUtil().getEntityManager();
        final Conta conta = new Conta();
        conta.setId(10);
        final Query query =
                        manager.createQuery("select m from Movimentacao m where m.conta=:pConta"
                                        + " and m.tipoMovimentacao = :pTipo"
                                        + " order by m.valor desc");
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        final List<Movimentacao> movimentacoes = query.getResultList();

        for (final Movimentacao m : movimentacoes) {
            System.out.println("\nDecrição ..: " + m.getDescricao());
            System.out.println("Valor......: R$" + m.getValor());
        }
    }
}
