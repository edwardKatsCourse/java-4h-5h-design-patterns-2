package com.company.composite;

import java.util.ArrayList;
import java.util.List;

public class MarketingDepartment implements Department {
    List<Department> marketingSubDepartments = new ArrayList<>();

    @Override
    public void printDepartmentName() {
        System.out.println("Marketing department");
    }

    @Override
    public Integer countEmployees() {
        return 100;
    }
}
