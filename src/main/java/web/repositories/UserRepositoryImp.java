package web.repositories;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
     private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void delete(int id) {
        User user = getById(id);
        em.remove(user);
    }

    @Override
    public void edit(User user) {
        em.merge(user);
    }

    @Override
    public User getById(int id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}