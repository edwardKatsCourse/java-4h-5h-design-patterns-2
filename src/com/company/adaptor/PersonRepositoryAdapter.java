package com.company.adaptor;

public class PersonRepositoryAdapter {

    private ХранилищеЛичности хранилищеЛичности;

    public PersonRepositoryAdapter(ХранилищеЛичности хранилищеЛичности) {
        this.хранилищеЛичности = хранилищеЛичности;
    }

    public void save(String personName) {
        if (personName == null) {
            this.хранилищеЛичности.сохранить();
        } else {
            this.хранилищеЛичности.обновить();
        }
    }
}
