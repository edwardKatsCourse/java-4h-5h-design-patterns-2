package com.company.decorator;

public interface PersonRepository {
    void save(String name);
}

class PersonRepositoryImpl implements PersonRepository {
    @Override
    public void save(String name) {
        System.out.printf("Saving object to the database '%s'\n", name);
    }
}
class PersonRepositoryDecorator implements PersonRepository {
    private PersonRepository personRepository;

    public PersonRepositoryDecorator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(String name) {
        try {
            System.out.println("Opening transaction...");
            this.personRepository.save(name);
            System.out.println("Transaction commit");
        } catch (Exception e) {
            System.out.println("Transaction rollback");
        }
    }
}

class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepositoryImpl();
        personRepository.save("John");

        System.out.println();
        System.out.println();
        System.out.println();
        PersonRepository personRepositoryWithDecorator = new PersonRepositoryDecorator(new PersonRepositoryImpl());
        personRepositoryWithDecorator.save("John");
    }
}