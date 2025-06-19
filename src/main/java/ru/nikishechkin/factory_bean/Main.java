package ru.nikishechkin.factory_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // FactoryBean в контексте:
        var modelFactory = context.getBean(ModelFactory.class);
        System.out.println(modelFactory.getClass()); // ModelFactory
        System.out.println(modelFactory.getObjectType()); // Model

        // Но в контекст был также внедрен объект Model:
        var model = context.getBean(Model.class);
        System.out.println(model.getClass());

        BaseService service = context.getBean(BaseService.class);
        service.printValue(); // Hello world

        System.out.println(service.getModel().getValue()); // 5+3=8
        System.out.println(service.getModel().equals(model)); // true
    }
}
