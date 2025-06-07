package ru.nikishechkin.ch2_ex2_primaryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Primary - koko
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Parrot p2 = context.getBean("mimi", Parrot.class);
        System.out.println(p2.getName());

        System.out.println(p == p2); // false
    }
}