package ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * Аспект будет вызываться для всех классов, входящих в указанный пакет, для всех его методов
     * с любым набором параметров
     */
    // @Around("execution(* ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut.services.*.*(..))")
    public Object allToLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute");

        // Получаем имя и параметры перехватываемого метода
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        // Вывод имени и параметров перехватываемого метода
        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        // Вызов перехватываемого метода
        Object returnedByMethod = joinPoint.proceed();

        logger.info("Method executed and returned " + returnedByMethod);

        return "FAILED"; // значение, возвращаемое из оригинального объекта - returnedByMethod;
    }

    /**
     *  Аспект будет вызван для методов, аннотированных аннотацией @ToLog
     */
    @Around("@annotation(toLog) && args(comment)") // Дополнительное условие, что в сигнатуре метода аргумент comment
    public Object log(ProceedingJoinPoint joinPoint, ToLog toLog, Comment comment) throws Throwable {

        logger.info("TOLOG: Method will execute: " + joinPoint.getSignature().getName());
        System.out.println("Comment from method: " + comment.getText());
        Object returnedByMethod = joinPoint.proceed();
        logger.info("TOLOG: Method executed");
        return returnedByMethod;
    }
}
