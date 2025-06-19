package ru.nikishechkin.spring_start_here.ch3_ex6_someBeans;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        Parrot p = context.getBean("parrot", Parrot.class);
//        System.out.println(p.getName());

        Person person = context.getBean("person", Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot().getName());

        Map<String, Entity> entities = context.getBeansOfType(Entity.class);

        System.out.println(entities); // person, parrot, mainParrot

        ServiceLoader<Entity> loader = ServiceLoader.load(Entity.class);
        List<Entity> list = StreamSupport.stream(loader.spliterator(), false)
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
