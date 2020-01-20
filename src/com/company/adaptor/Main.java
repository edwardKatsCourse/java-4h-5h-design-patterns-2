package com.company.adaptor;

public class Main {


    public static void main(String[] args) {
        PersonRepositoryAdapter personRepositoryAdapter = new PersonRepositoryAdapter(new ХранилищеЛичности());
        personRepositoryAdapter.save(null);
    }
}
