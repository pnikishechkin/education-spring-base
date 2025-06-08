package ru.nikishechkin.spring_the_ripper.three_phase_constructor.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.nikishechkin.spring_the_ripper.three_phase_constructor.ProfilingController;
import ru.nikishechkin.spring_the_ripper.three_phase_constructor.annotations.Profiling;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        /*
        MBean (Managed Bean) — это специальный Java-объект, который представляет управляемый ресурс в технологии
        JMX (Java Management Extensions). Он используется для мониторинга и управления приложениями, серверами
        (например, Tomcat, WildFly) или JVM в реальном времени через инструменты вроде JConsole, VisualVM, или через
        веб-интерфейсы (например, Spring Boot Actuator).
         */
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("ProfilingHandlerBeanPostProcessor postProcessBeforeInitialization, class: " + bean.getClass().getName());
        Class<?> beanClass = bean.getClass();

        // Запоминаем, какие бины помечены аннотацией Profiling
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("ProfilingHandlerBeanPostProcessor postProcessAfterInitialization, class: " + bean.getClass().getName());
        Class beanClass = map.get(beanName);
        // Бин, который запомнили в мапе
        if (beanClass != null) {
            // Создает объект из нового класса, который он сам сгенрирует на лету
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            Object retVal = null;
                            if (controller.isEnabled()) {
                                System.out.println("Профилирую...");
                                long before = System.nanoTime();
                                System.out.println();
                                retVal = method.invoke(bean, args);
                                long after = System.nanoTime();
                                System.out.println(after - before);
                                System.out.println("Всё.");
                            } else {
                                return method.invoke(bean, args);
                            }
                            return retVal;
                        }
                    });
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
