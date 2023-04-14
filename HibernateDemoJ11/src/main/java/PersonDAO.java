
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class PersonDAO {

    private EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }

    public void update(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void delete(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
