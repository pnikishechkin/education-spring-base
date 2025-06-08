package ru.nikishechkin.spring_the_ripper.bean_post_processor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для профилирования - вывода в лог времени инициализации.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
