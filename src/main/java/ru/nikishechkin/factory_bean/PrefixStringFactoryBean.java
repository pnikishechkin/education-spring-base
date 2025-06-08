package ru.nikishechkin.factory_bean;

import org.springframework.beans.factory.FactoryBean;

public class PrefixStringFactoryBean implements FactoryBean<String> {
    private String prefix;
    private String value;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getObject() {
        return prefix + value; // Генерируем строку с префиксом
    }

    @Override
    public Class<?> getObjectType() {
        return String.class; // Тип возвращаемого объекта
    }

    @Override
    public boolean isSingleton() {
        return true; // Будет ли бин синглтоном
    }
}
