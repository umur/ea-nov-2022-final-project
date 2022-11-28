package project.comment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.comment_service.CommentServiceApplication;
import project.comment_service.entity.Comment;
import project.comment_service.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<String> saveComment(
            @RequestBody Comment comment){
        commentService.saveComment(comment);
        return new ResponseEntity<>("comment saved ", HttpStatus.OK);
    }

    @GetMapping("/{digitalvideoid}")
    public List<Comment> getCommentsByDigitalVideo(@PathVariable long digitalvideoid){
      return  commentService.getCommentsByDigitalVideo(digitalvideoid);
    }
    @GetMapping("/user/{userid}")
    public List<Comment> getCommentsByUser(@PathVariable long userid){
        return  commentService.getCommentsByUser(userid);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
       String response= commentService.deleteComment(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
