package ru.nikishechkin.spring_start_here.ch3_ex8_notCyclic_lazy;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Проблема избыточного проксирования в Spring при ленивой инициализации (@Lazy) возникает из-за того,
 * что Spring вынужден создавать прокси-объекты для отложенного доступа к бинам.
 * Это может привести к неочевидным побочным эффектам и накладным расходам.
 */
public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean("parrot", Parrot.class);
        parrot.setName("Кеша"); // Новое имя

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getParrotName()); // Кеша
        System.out.println(parrot.getClass().getName()); // Прокси-заглушка (CGLIB)

        System.out.println("Equals: " + parrot.equals(person.getParrot())); // false! Прокси и оригинальный бин — разные объекты.
        // Т.к. объект Parrot в Person - " прокси объект

        System.out.println(AopUtils.isAopProxy(parrot)); // false
        System.out.println(AopUtils.isAopProxy(person.getParrot())); // true

        person.setParrotName("Коко");
        System.out.println(AopUtils.isAopProxy(person.getParrot())); // true
    }
}
