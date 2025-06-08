package ru.nikishechkin.spring_the_ripper.three_phase_constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Quoter p = context.getBean(Quoter.class);
    }
}