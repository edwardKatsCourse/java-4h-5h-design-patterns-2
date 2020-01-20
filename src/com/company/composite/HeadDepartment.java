package com.company.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeadDepartment implements Department {

    private static final Integer HEAD_EMPLOYEES_COUNT = 10;

    private List<Department> departments = new ArrayList<>();

    @Override
    public void printDepartmentName() {
        departments.forEach(System.out::println);
    }

    @Override
    public Integer countEmployees() {
        Integer collect = departments.stream().map(Department::countEmployees).reduce(HEAD_EMPLOYEES_COUNT, Integer::sum);
        return collect.intValue();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void removeDepartment(Department department) {
        this.departments.remove(department);
    }
}
