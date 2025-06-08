package ru.nikishechkin.spring_the_ripper.bean_post_processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        while (true) {
            Thread.sleep(2000);
            context.getBean(Quoter.class).sayQuote();
        }
    }
}