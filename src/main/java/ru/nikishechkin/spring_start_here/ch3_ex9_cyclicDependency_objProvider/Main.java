package ru.nikishechkin.spring_start_here.ch3_ex9_cyclicDependency_objProvider;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean("parrot", Parrot.class);
        parrot.setName("Кеша"); // Новое имя

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getParrotName()); // Кеша
        System.out.println(parrot.getClass().getName()); // Не Прокси

        System.out.println(parrot.equals(person.getParrot())); // true, т.к. не прокси

        System.out.println(AopUtils.isAopProxy(parrot)); // false
        System.out.println(AopUtils.isAopProxy(person.getParrot())); // false

        System.out.println(parrot.getPerson().getClass().getName()); // Не прокси

        person.setParrotName("Коко");
        System.out.println(AopUtils.isAopProxy(person.getParrot())); // false
    }
}
