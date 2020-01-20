package com.company.signleton;

public class LazySingleton {

    public static String PRINTER_TYPE = "10 years old printer";

    private static LazySingleton instance = null;

    private LazySingleton() {
        try {
            System.out.println("Connecting to printer... ");
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
        }
        System.out.println("Connection established");
    }

    //what if this 'thing' is supposed to work in multithreading
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}


//class Main {
//    public static void main(String[] args) {
//        System.out.println(LazySingleton.PRINTER_TYPE);
//
//        //waiting for 10 seconds to connect with printer
//        LazySingleton.getInstance();
//        //instance created
//
//
//        LazySingleton.getInstance();
//        LazySingleton.getInstance();
//        LazySingleton.getInstance();
//        LazySingleton.getInstance();
//    }
//}