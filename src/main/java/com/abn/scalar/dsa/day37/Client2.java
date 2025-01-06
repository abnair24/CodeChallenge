package com.abn.scalar.dsa.day37;

public class Client2 {

    public static void main(String[] args) {
        Student1 s1 = new Student1();
        s1.age = 10;
        s1.name = "A";

        Student1 s2 = new Student1();
        s2.age = 20;
        s2.name = "B";

        swap(s1, s2);

        s1.display();
    }

    private static void swap(Student1 s1, Student1 s2) {
        Student1 temp = s1;
        s1 = s2;
        s2 = temp;
    }
}

class Student1 {
    int age;
    String name;

    void display(){
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }

    void sayHello(String name){
        System.out.println(this.name + " says hello to " + name);
    }
}
