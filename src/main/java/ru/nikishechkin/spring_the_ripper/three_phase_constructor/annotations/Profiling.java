package ru.nikishechkin.spring_the_ripper.three_phase_constructor.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для профилирования - вывода в лог времени инициализации.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
