package ru.nikishechkin.spring_start_here.ch3_ex5_cyclicDependency.ex1_base;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // org.springframework.beans.factory.UnsatisfiedDependencyException

        Parrot p = context.getBean("parrot", Parrot.class);
        System.out.println(p.getName());

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot().getName());
    }
}
