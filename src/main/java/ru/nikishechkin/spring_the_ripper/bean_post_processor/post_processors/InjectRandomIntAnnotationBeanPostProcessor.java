package ru.nikishechkin.spring_the_ripper.bean_post_processor.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import ru.nikishechkin.spring_the_ripper.bean_post_processor.annotations.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InjectRandomIntAnnotationBeanPostProcessor:postProcessBeforeInitialization, class: " + bean.getClass().getName());
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                field.setAccessible(true); // получаем доступ к полю, даже если он private
                // выполняем установку значения поля (field) объекта (bean) с помощью рефлексии, даже если поле
                // приватное или недоступно напрямую
                ReflectionUtils.setField(field, bean, i);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InjectRandomIntAnnotationBeanPostProcessor:postProcessAfterInitialization, class: " + bean.getClass().getName());
        return bean;
    }
}
