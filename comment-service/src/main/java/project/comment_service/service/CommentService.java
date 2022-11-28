package project.comment_service.service;

import project.comment_service.entity.Comment;

import java.util.List;

public interface CommentService {

    void saveComment(Comment comment);
    List<Comment> getCommentsByDigitalVideo(long digitalVideoId);
    List<Comment> getCommentsByUser(long userId);

    String deleteComment(long id);

}
