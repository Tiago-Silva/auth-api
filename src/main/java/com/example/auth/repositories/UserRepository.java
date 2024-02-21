package com.example.auth.repositories;

import com.example.auth.domain.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    private CriteriaBuilder getCriteriaBuilder() {
        return em.getCriteriaBuilder();
    }

    public User getUserByLogin(String login) {
        CriteriaBuilder builder = this.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        // Adicione um predicado para filtrar com base no login
        criteriaQuery.where(builder.equal(root.get("login"), login));

        TypedQuery<User> query = this.em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
    @Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.SERIALIZABLE)
    public void save(Object objeto) {
        em.persist(objeto);
        em.flush();
    }

    @Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.SERIALIZABLE)
    public Object saveWithReturn(Object objeto) {
        em.persist(objeto);
        em.flush();
        return objeto;
    }
    @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE)
    public void delete(Object objeto) {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE)
    public void update(Object objeto) {
        em.merge(objeto);
    }

    @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE)
    public Object updateWithReturn(Object objeto) {
        em.merge(objeto);
        return objeto;
    }
}
