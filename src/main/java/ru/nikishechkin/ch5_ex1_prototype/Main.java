package ru.nikishechkin.ch5_ex1_prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Petr");
        comment.setText("Comment");

        var service = context.getBean(CommentService.class);
        service.pushComment(comment);

        var service2 = context.getBean(CommentService.class);

        System.out.println(service == service2);
        System.out.println(service.getCommentRepository() == service2.getCommentRepository());

        var commentRepository = context.getBean(CommentRepository.class);
        var commentRepository2 = context.getBean(CommentRepository.class);

        System.out.println(service.getCommentRepository() == commentRepository);
        System.out.println(service.getCommentRepository() == commentRepository2);
        System.out.println(commentRepository == commentRepository2);

    }
}
