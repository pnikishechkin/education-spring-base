package ru.nikishechkin.ch4_ex2_abstractionCustomAnnotation;

import org.springframework.stereotype.Component;

@EmailNotification
@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }
}
