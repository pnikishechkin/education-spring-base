package ru.nikishechkin.ch2_ex1_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Parrot p2 = context.getBean("parrot", Parrot.class);
        System.out.println(p2.getName());

        System.out.println(p == p2); // true

        String s = context.getBean(String.class);
        System.out.println(s); // Hello

        Integer i = context.getBean(Integer.class);
        System.out.println(i); // 10
    }
}