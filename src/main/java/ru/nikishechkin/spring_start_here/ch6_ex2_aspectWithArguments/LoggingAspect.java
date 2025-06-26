package ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments;

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
    @Around("execution(* ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments.services.*.*(..))")
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
    @Around("@annotation(toLog)")
    public Object log(ProceedingJoinPoint joinPoint, ToLog toLog) throws Throwable {

        // Получаем значение аргумента из своей аннотации ToLog
        if (toLog.printToConsole()) {
            System.out.println("CONSOLE PRINT: Logger method started");
        } else {
            System.out.println("quietly console print");
        }

        logger.info("TOLOG: Method will execute");
        Object returnedByMethod = joinPoint.proceed();
        logger.info("TOLOG: Method executed");
        return returnedByMethod;
    }
}
