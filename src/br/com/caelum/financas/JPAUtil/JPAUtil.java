package br.com.caelum.financas.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory = Persistence
                    .createEntityManagerFactory("financas");



    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }



    public static void setEntityManagerFactory(final EntityManagerFactory entityManagerFactory) {
        JPAUtil.entityManagerFactory = entityManagerFactory;
    }



    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
