package ru.nikishechkin.spring_the_ripper.bean_post_processor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min();
    int max();
}
