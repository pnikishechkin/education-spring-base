package ru.nikishechkin.spring_start_here.ch6_ex1_aspect.services;

import org.springframework.stereotype.Service;
import ru.nikishechkin.spring_start_here.ch6_ex1_aspect.Comment;
import ru.nikishechkin.spring_start_here.ch6_ex1_aspect.ToLog;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }
}
