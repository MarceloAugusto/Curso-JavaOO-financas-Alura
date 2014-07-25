package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

    private final EntityManager manager;


    public MovimentacaoDAO(final EntityManager manager) {
        this.manager = manager;
    }


    public Double mediaDaContaPeloTipo(final Conta conta, final TipoMovimentacao tipo) {

        final TypedQuery<Double> query =
                        this.manager.createQuery(
                                        "select avg(m.valor) from Movimentacao m where m.conta = :pConta "
                                                        + "and m.tipoMovimentacao = :pTipo",
                                        Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipo);

        final Double media = query.getSingleResult();
        return media;
    }

}
