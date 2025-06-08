package ru.nikishechkin.spring_the_ripper.bean_post_processor;

import jakarta.annotation.PostConstruct;
import ru.nikishechkin.spring_the_ripper.bean_post_processor.annotations.InjectRandomInt;
import ru.nikishechkin.spring_the_ripper.bean_post_processor.annotations.Profiling;

@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Базовый конструктор (Phase 1): " + repeat);
    }

    @PostConstruct
    public void PostConstructMethod() {
        System.out.println("Инит метод (Phase 2): " + repeat);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
