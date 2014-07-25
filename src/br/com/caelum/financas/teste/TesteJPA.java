package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import JPAUtil.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteJPA {

    public static void main(final String[] args) {



        final Conta conta = new Conta();
        // conta.setId(8);
        conta.setTitular("Beotrano da Silva souza");
        conta.setBanco("Bradesco Uberaba");
        conta.setAgencia("12345");
        conta.setConta("10203040");

        final EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        /*
         * EntityManagerFactory entityManagerFactory =
         * Persistence.createEntityManagerFactory("financas"); EntityManager manager =
         * entityManagerFactory.createEntityManager();
         */

        /*
         * EntityManager persist(entidade) -> insere find(class, id) -> busca merge(entidade) ->
         * update remove(entidade) -> remover
         */

        // inicio find (Busca)
        /*
         * final Conta contas = em.find(Conta.class, 8); System.out.println(contas.getTitular());
         */

        // inicio persist (Insert)
        // conta.setTitular("alterado");
        // em.persist(conta);
        // System.out.println(conta.getTitular());

        // inicio merge (update or insert)
        // conta.setTitular("alterado");
        // em.merge(conta);
        // System.out.println(conta.getTitular());

        // inicio remove
        final Conta contas = em.find(Conta.class, 9);
        System.out.println(contas.getTitular());
        em.remove(contas);

        em.getTransaction().commit();

        em.close();
    }

}
