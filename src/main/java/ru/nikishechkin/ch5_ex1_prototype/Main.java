package ru.nikishechkin.ch5_ex1_prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Petr");
        comment.setText("Comment");

        // Service - одиночная область видимости - BeanDefinition.SCOPE_SINGLETON
        var service = context.getBean(CommentService.class);
        service.pushComment(comment);

        var service2 = context.getBean(CommentService.class);

        System.out.println(service == service2); // true
        // Пример внедрения прототипных бинов в бины с одиночной областью видимости.
        // Экземпляры одиночных бинов всегда используют один и тот же экземпляр прототипных бинов
        System.out.println(service.getCommentRepository() == service2.getCommentRepository()); // true

        // CommentRepository - прототипный бин - BeanDefinition.SCOPE_PROTOTYPE
        var commentRepository = context.getBean(CommentRepository.class);
        var commentRepository2 = context.getBean(CommentRepository.class);

        System.out.println(service.getCommentRepository() == commentRepository); // false
        System.out.println(service.getCommentRepository() == commentRepository2); // false
        System.out.println(commentRepository == commentRepository2); // false

    }
}
