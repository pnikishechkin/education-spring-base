package ru.nikishechkin.spring_the_ripper.three_phase_constructor;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.nikishechkin.spring_the_ripper.three_phase_constructor.annotations.InjectRandomInt;
import ru.nikishechkin.spring_the_ripper.three_phase_constructor.annotations.PostProxy;
import ru.nikishechkin.spring_the_ripper.three_phase_constructor.annotations.Profiling;

@Profiling
@Component
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message = "Hello";

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
    @PostProxy
    public void sayQuote() {
        System.out.println("PostProxy (Phase 3)");
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
