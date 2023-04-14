package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("João", 30);
        Person person2 = new Person("Maria", 25);

        // Insert
        PersonDAO.create(person1);
        PersonDAO.create(person2);

        // Update
        person1.setAge(35);
        PersonDAO.update(person1);

        // Select all
        List<Person> persons = PersonDAO.findAll();
        for (Person person : persons) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}

