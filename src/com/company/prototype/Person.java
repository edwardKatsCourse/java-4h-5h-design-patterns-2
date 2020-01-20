package com.company.prototype;

//Shallow Copy
//Deep Copy
public class Person /*extends Object*/ implements Cloneable {
    private String name; //immutable
    private Car car;

    public Person(String name, Car car) {
        //super();
        this.name = name;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    @Override
    public Person clone() {
        //shallow copy
        try {
            //super - Object
            return (Person) super.clone(); //new Person('john', 'honda');
        } catch (CloneNotSupportedException e) {
            return null;
        }

        //deep copy
//        return new Person(this.name, new Car(this.car.getCarName()));
    }

    /***
     * protected Object clone() throws CloneNotSupportedException {
     *     return super.clone();
     * }
     */
}

class Car {
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        Car honda = new Car("Honda");

        //by-value | by-reference
        Person john = new Person("John", honda);
        System.out.println("Person после создания");
        System.out.println(john);

        stealPerson1(john);
        System.out.println("Person после 1й попытки 'угона'");
        System.out.println(john);

        System.out.println();
        System.out.println("Person после 2й попытки 'угона'");
        Person sarah = john.clone(); //'john'
        stealPerson2(sarah); //'sarah', car=stolen
        System.out.println("john object -> " + john);
        System.out.println("sarah object -> " + sarah);

    }

    public static void stealPerson1(Person person) {
        person = new Person("Sarah", new Car("Stolen Car"));

    }

    //final fields
    //+
    //no setters
    //=
    //no steals
    public static void stealPerson2(Person person) {
        person.setName("Sarah");
        person.getCar().setCarName("Stolen Car");
    }
}
