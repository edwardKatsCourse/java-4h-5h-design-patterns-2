package com.company.signleton;

public class MultithreadingSingleton {

    private MultithreadingSingleton() {

    }

    //1 вызов
    //100 раз
//    public static synchronized MultithreadingSingleton getInstance() {
//        if (instance == null) {
//            instance = new MultithreadingSingleton();
//        }
//        return instance;
//    }
    private static volatile MultithreadingSingleton instance = null;
    //creation object
    //phase - 1
    //phase - 2
    //phase - 3 instance != null = true

    //Happens-Before - no guarantee of happens before
    public static MultithreadingSingleton getInstance() {

        if (instance == null) {
            //thread 2
            synchronized (MultithreadingSingleton.class) {
                if (instance == null) {
                    instance = new MultithreadingSingleton();//thread 1

                }
            }
        }
        //thread 3
        return instance;
    }

}
