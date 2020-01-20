package com.company.proxy;

import java.util.List;

public interface PersonRepository {
    void save(String name);
}

class PersonRepositoryImpl implements PersonRepository {
    @Override
    public void save(String name) {
        System.out.printf("Saving object to the database '%s'\n", name);
    }
}

class PersonRepositoryProxy implements PersonRepository {
    private PersonRepository personRepository;

    public PersonRepositoryProxy(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(String name) {
        if (name.equals("John")) {
            throw new RuntimeException("No more 'John's allowed on this webinar");
        }
        this.personRepository.save(name);
    }
}

class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepositoryImpl();
        personRepository.save("John");

        System.out.println();
        System.out.println();
        System.out.println();
        PersonRepository personRepositoryWithProxy = new PersonRepositoryProxy(new PersonRepositoryImpl());
        personRepositoryWithProxy.save("Sarah");
    }
}