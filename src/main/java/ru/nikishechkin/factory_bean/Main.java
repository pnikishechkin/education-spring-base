package ru.nikishechkin.factory_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        BaseService service = context.getBean(BaseService.class);
        service.print(); // Hello world

        var fb = context.getBean(PrefixStringFactoryBean.class);
        System.out.println(fb.getClass());
        System.out.println(fb.getObjectType()); // String

    }
}
