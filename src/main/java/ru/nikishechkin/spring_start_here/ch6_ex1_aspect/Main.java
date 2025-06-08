package ru.nikishechkin.spring_start_here.ch6_ex1_aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nikishechkin.spring_start_here.ch6_ex1_aspect.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Peter");

        System.out.println(service.publishComment(comment));
        service.deleteComment(comment);
    }
}
