package tai.example.demo.services;

import org.springframework.http.ResponseEntity;
import tai.example.demo.dto.CommentAndUserInfoDto;
import tai.example.demo.model.Comment;

import java.util.List;

/**
 * Comment service interface
 *
 * @author TuMV
 */
public interface ServiceCommentService {

    /**
     * Get all comment
     *
     * @author TuMV
     * @return all comment
     */
    ResponseEntity<List<Comment>> getAllComment();

    /**
     * Get list comment by user id
     *
     * @author TuMV
     * @param intUserId
     * @return list comment and user info
     */
    ResponseEntity<List<CommentAndUserInfoDto>> getCommentByUserId(int intUserId);
}
