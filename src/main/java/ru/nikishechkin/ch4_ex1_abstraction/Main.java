package ru.nikishechkin.ch4_ex1_abstraction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Petr");
        comment.setText("Comment");

        var service = context.getBean(CommentService.class);
        service.pushComment(comment);

    }
}
