package ru.nikishechkin.ch4_ex2_abstractionCustomAnnotation;

import org.springframework.stereotype.Component;

@PushNotification
@Component
public class CommentPushNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: " + comment.getText());
    }
}
