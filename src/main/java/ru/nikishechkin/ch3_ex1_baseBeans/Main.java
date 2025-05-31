package ru.nikishechkin.ch3_ex1_baseBeans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean("parrot", Parrot.class);
        System.out.println(p.getName());

        Parrot p2 = context.getBean("Poko", Parrot.class);
        System.out.println(p2.getName());

        System.out.println(p == p2); // false

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer i = context.getBean(Integer.class);
        System.out.println(i);

        Cat c = context.getBean(Cat.class);
        System.out.println(c.getName());

        Cat c2 = context.getBean(Cat.class);
        System.out.println(c == c2); // true - один и тот же объект

        System.out.println("--------------------------------------------");
        Cat x = new Cat();
        x.setName("Begemot");
        Supplier<Cat> catSupplier = () -> x;
        context.registerBean("Begemot", Cat.class, catSupplier /*, bc -> bc.setPrimary(true) */);
        System.out.println(x.getName()); // Begemot
        Cat begemot = context.getBean("Begemot", Cat.class); // на данном этапе происходит вызов init
        System.out.println(begemot.getName()); // Murka
        System.out.println(c == begemot); // false - один и тот же объект
    }
}