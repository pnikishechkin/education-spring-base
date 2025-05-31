package ru.nikishechkin.ch3_ex4_autowiredConstructorBeans;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // IoC - принцип, который подразумевает, что фреймворк управляет выполнением приложения
        // DI (Dependency Injection) - применение принципа IoC, заключается в том, что фреймворк присваивает значение
        // определенному полю или параметру

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean("parrot", Parrot.class);
        System.out.println(p.getName());

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot().getName());
    }
}
