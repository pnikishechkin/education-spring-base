package ru.nikishechkin.spring_start_here.ch3_ex10_cyclicDependency_setter;

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

        System.out.println("Equals: " + parrot.equals(person.getParrot())); // true, т.к. не прокси

        System.out.println(AopUtils.isAopProxy(parrot.getPerson())); // false
        System.out.println(AopUtils.isAopProxy(person.getParrot())); // false
    }
}
