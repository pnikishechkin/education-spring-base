package ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments.services;

import org.springframework.stereotype.Service;
import ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments.Comment;
import ru.nikishechkin.spring_start_here.ch6_ex2_aspectWithArguments.ToLog;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @ToLog(printToConsole = true)
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    @ToLog(printToConsole = false)
    public void deleteCommentQuietly(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }
}
