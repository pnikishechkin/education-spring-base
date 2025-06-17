package ru.nikishechkin.spring_start_here.ch3_ex7_cyclicDependency_lazy;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean("parrot", Parrot.class);
        parrot.setName("Кеша"); // Новое имя

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getParrotName()); // Кеша
        System.out.println(parrot.getClass().getName()); // Прокси-заглушка (CGLIB)

        System.out.println(parrot.equals(person.getParrot())); // false! Т.к. объект Parrot в Person - прокси объект

        System.out.println(AopUtils.isAopProxy(parrot)); // false
        System.out.println(AopUtils.isAopProxy(person.getParrot())); // true

        System.out.println(parrot.getPerson().getClass().getName()); // Не прокси

        person.setParrotName("Коко");
        System.out.println(AopUtils.isAopProxy(person.getParrot())); // true
    }
}
