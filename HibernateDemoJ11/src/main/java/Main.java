import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            // Cria o EntityManagerFactory com as configurações do arquivo persistence.xml
            //entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            entityManagerFactory = HibernateUtil.getEntityManagerFactory();

            // Cria o EntityManager
            entityManager = entityManagerFactory.createEntityManager();

            // Cria o DAO com o EntityManager
            PersonDAO personDAO = new PersonDAO(entityManager);

            // Salva uma nova Person
            Person pessoa1 = new Person("João", 25);
            personDAO.save(pessoa1);

            // Busca uma Person pelo ID
            Person pessoa2 = personDAO.findById(14L);
            System.out.println(pessoa2);

            Person pessoa3 = new Person("Maria", 22);
            personDAO.save(pessoa3);

            Person pessoa4 = new Person("ALDO", 22);
            personDAO.save(pessoa4);

            // Atualiza uma Person existente
            pessoa1.setAge(50);
            personDAO.update(pessoa1);
            System.out.println(pessoa1);

            // Busca todas as Persons
            List<Person> pessoas = personDAO.findAll();
            pessoas.forEach(System.out::println);

            // Deleta uma Person
            personDAO.delete(pessoa4);

            // Busca todas as Persons novamente
            pessoas = personDAO.findAll();
            pessoas.forEach(System.out::println);

        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
            if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
                entityManagerFactory.close();
            }
        }
    }
}
