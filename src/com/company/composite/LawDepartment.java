package com.company.composite;

public class LawDepartment implements Department {

    @Override
    public void printDepartmentName() {
        System.out.println("Law Department");
    }

    @Override
    public Integer countEmployees() {
        return 50;
    }
}
