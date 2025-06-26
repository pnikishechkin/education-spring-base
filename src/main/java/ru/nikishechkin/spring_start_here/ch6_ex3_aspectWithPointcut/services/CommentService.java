package ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut.services;

import org.springframework.stereotype.Service;
import ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut.Comment;
import ru.nikishechkin.spring_start_here.ch6_ex3_aspectWithPointcut.ToLog;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @ToLog()
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    @ToLog()
    public void deleteCommentWithAddArgs(Comment comment, int value) {
        logger.info("Deleting comment: " + comment.getText());
    }
}
