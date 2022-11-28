package project.comment_service.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.comment_service.entity.Comment;
import project.comment_service.repository.CommentRepo;
import project.comment_service.service.CommentService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Override
    public void saveComment(Comment comment) {
     commentRepo.save(comment);
    }

    @Override
    public List<Comment> getCommentsByDigitalVideo(long digitalVideoId) {
      List<Comment> comments= commentRepo.findAllByDigitalVideoId(digitalVideoId);
      List<Comment> filteredComments=comments.stream().filter(c->c.isDeleted()==false).toList();

      return filteredComments;
    }

    @Override
    public List<Comment> getCommentsByUser(long userId) {
        List<Comment> comments= commentRepo.findAllByUserId(userId);
        List<Comment> filteredComments=comments.stream().filter(c->c.isDeleted()==false).toList();
        return filteredComments;
    }

    @Override
    @Transactional
    public String deleteComment(long id) {
        try{
            Comment comment=commentRepo.findById(id).get();
            comment.setDeleted(true);

        }catch(NoSuchElementException e){
         return "comment not found";
        };
       return "comment deleted";
    }
}
