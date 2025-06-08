package ru.nikishechkin.spring_the_ripper.three_phase_constructor.post_processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.nikishechkin.spring_the_ripper.three_phase_constructor.annotations.PostProxy;

import java.lang.reflect.Method;

@Component
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory; // Главная фабрика Spring - умеет делать GetBeanDefinition

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();

        // Имена бинов - но если уже есть прокси объект, то его имя будет Proxy$7
        String[] names = context.getBeanDefinitionNames();

        for (String name: names) {
            // Объект, содержащий метаинформацию о бине на этапе его создания. Это "чертеж" бина, описывающий его
            // свойства до фактического создания экземпляра
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);

            // Имя оригинального класса
            String originalClassName = beanDefinition.getBeanClassName();
            // System.out.println("BeanDefinitionName: " + name + " | originalClassName: " + originalClassName);

            try {
                if (originalClassName == null) {
                    continue;
                }

                // Объект класса (для получения его описания)
                Class<?> originalClass = Class.forName(originalClassName);
                // Список методов полученного класса
                Method[] methods = originalClass.getMethods();

                for (Method method: methods) {
                    // Если есть метод, аннотированный нашей аннотацией 3 фазы конструктора
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        // method.invoke() - через DynamicProxy не сработает; через CGLIB сработает
                        // ищем данный метод в оригинальном классе

                        Object bean = context.getBean(name);
                        Method currentMethod = bean.getClass().getMethod(
                                method.getName(),
                                method.getParameterTypes());
                        // ReflectionUtils.invokeMethod(currentMethod, bean);
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
