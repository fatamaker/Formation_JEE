package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Formation;
import util.JPAutil;

public class FormationDaoImpl implements IFormationDao {
    private EntityManager entityManager = JPAutil.getEntityManager("FormationJPA2");

    @Override
    public Formation save(Formation f) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(f);
        tx.commit();
        return f;
    }

    @Override
    public List<Formation> formationsParMC(String mc) {
        return entityManager.createQuery("SELECT f FROM Formation f WHERE f.nomFormation LIKE :mc", Formation.class)
                .setParameter("mc", "%" + mc + "%")
                .getResultList();
    }

    @Override
    public Formation getFormation(Long id) {
        return entityManager.find(Formation.class, id);
    }

    @Override
    public Formation updateFormation(Formation f) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Formation updatedFormation = entityManager.merge(f);
        tx.commit();
        return updatedFormation;
    }

    @Override
    public void deleteFormation(Long id) {
        Formation formation = entityManager.find(Formation.class, id);
        if (formation != null) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(formation);
            tx.commit();
        }
    }
}
