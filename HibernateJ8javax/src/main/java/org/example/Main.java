package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        // Cria uma nova pessoa
        Person person = new Person();
        person.setName("João");
        person.setAge(30);
        personDAO.save(person);

        // Lista todas as pessoas cadastradas
        List<Person> people = personDAO.findAll();
        for (Person p : people) {
            System.out.println(p.getId() + " - " + p.getName() + " - " + p.getAge());
        }

        // Atualiza a idade da pessoa criada anteriormente
        person.setAge(31);
        personDAO.update(person);

        // Lista novamente todas as pessoas cadastradas
        people = personDAO.findAll();
        for (Person p : people) {
            System.out.println(p.getId() + " - " + p.getName() + " - " + p.getAge());
        }
    }
}
