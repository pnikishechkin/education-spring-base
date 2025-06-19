package ru.nikishechkin.factory_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseService {
    @Autowired
    private final Model model;
    // Получаем бин, который будет создан через FactoryBean и выполнится дополнительная логика при создании

    public BaseService(Model model) {
        this.model = model;
    }

    public void printValue() {
        System.out.println(model.getValue());
    }

    public Model getModel() {
        return model;
    }
}
