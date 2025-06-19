package ru.nikishechkin.factory_bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.FactoryBean;

public class ModelFactory implements FactoryBean<Model> {

    private Integer delta = 0;

    public ModelFactory() {
        System.out.println("ModelFactory constructor");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("ModelFactory post-constructor");
    }

    @Override
    public Model getObject() throws Exception {
        Model model = new Model();
        model.setValue(model.getValue() + delta); // Доп логика
        return model;
    }

    @Override
    public Class<?> getObjectType() {
        return Model.class;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }
}
