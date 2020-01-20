package com.company.composite;

public class Main {
    public static void main(String[] args) {
        HeadDepartment headDepartment = new HeadDepartment();

        Department lawDepartment = new LawDepartment();
        MarketingDepartment marketingDepartment = new MarketingDepartment();

        System.out.println("Adding law and marketing department");
        headDepartment.addDepartment(lawDepartment);
        headDepartment.addDepartment(marketingDepartment);
        System.out.println();
        headDepartment.printDepartmentName();
        headDepartment.removeDepartment(lawDepartment);
        System.out.println();
        System.out.println("...Removing law department");
        headDepartment.printDepartmentName();


        System.out.println("Total employees count: " + headDepartment.countEmployees());
        System.out.println("Marketing employees count: " + marketingDepartment.countEmployees());
    }
}
