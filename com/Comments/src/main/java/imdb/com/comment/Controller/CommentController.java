package imdb.com.comment.Controller;

import imdb.com.comment.Entity.Comment;
import imdb.com.comment.Service.CommentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {


    private CommentServiceImpl commentService;


    @GetMapping
    public List<Comment> findAllComment() {
        return commentService.findAllComment();
    }


}
