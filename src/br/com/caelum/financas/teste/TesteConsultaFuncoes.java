package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import JPAUtil.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TesteConsultaFuncoes {
    public static void main(final String[] args) {
        final EntityManager manager = new JPAUtil().getEntityManager();
        final Conta conta = new Conta();
        conta.setId(10);

        final TypedQuery<Double> query =
                        manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        final Double media = query.getSingleResult();


        System.out.println("Soma: " + media);
    }
}
