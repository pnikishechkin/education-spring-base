package ru.nikishechkin.spring_start_here.ch3_ex6_someBeans;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        Parrot p = context.getBean("parrot", Parrot.class);
//        System.out.println(p.getName());

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot().getName());
    }
}
