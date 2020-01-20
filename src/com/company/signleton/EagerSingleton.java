package com.company.signleton;

public class EagerSingleton {

    private static final EagerSingleton john = new EagerSingleton();

    public static String PRINTER_TYPE = "10 years old printer";

    private EagerSingleton() {
        try {
            System.out.println("Connecting to printer...");
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connection established");
    }

    public static EagerSingleton getInstance() {
        return john;
    }
}

//class Main {
//    public static void main(String[] args) {
//        System.out.println(EagerSingleton.PRINTER_TYPE);
//    }
//}
