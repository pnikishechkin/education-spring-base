package ru.nikishechkin.spring_start_here.ch2_ex5_registerBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        boolean state = true;

        Parrot p = new Parrot();
        p.setName("Koko");

        Parrot p2 = new Parrot();
        p2.setName("Mimi");

        Supplier<Parrot> parrotSupplier = () -> p;
        Supplier<Parrot> parrotSupplier2 = () -> p2;

        if (state) {
            context.registerBean("parrot", Parrot.class, parrotSupplier);
        } else {
            context.registerBean("parrot", Parrot.class, parrotSupplier2);
        }

        Parrot parrotFromContext = context.getBean(Parrot.class);
        System.out.println(parrotFromContext.getName());
    }
}