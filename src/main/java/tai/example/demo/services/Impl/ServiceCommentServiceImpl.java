package tai.example.demo.services.Impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tai.example.demo.dto.CommentAndUserInfoDto;
import tai.example.demo.model.Comment;
import tai.example.demo.model.User;
import tai.example.demo.services.ServiceCommentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Comment service implement comment interface
 *
 * @author TuMV
 */
@Service
public class ServiceCommentServiceImpl implements ServiceCommentService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Get all comments
     *
     * @author TuMV
     * @return all comments
     */
    @Override
    public ResponseEntity<List<Comment>> getAllComment() {
        String strSql = "FROM Comment as cmt ORDER BY cmt.id";
        List<Comment> lstComment = (List<Comment>) entityManager.createQuery(strSql).getResultList();
        return ResponseEntity.ok(lstComment);
    }

    /**
     * Get comment by id
     *
     * @author TuMV
     * @param intUserId
     * @return comment
     */
    @Override
    public ResponseEntity<List<CommentAndUserInfoDto>> getCommentByUserId(int intUserId) {
        StringBuilder strSqlSelect = new StringBuilder();
        // SQL Select
        strSqlSelect.append("SELECT new " + CommentAndUserInfoDto.class.getName() + " (a.content, b.userName, b.age) ");
        // SQL condition
        strSqlSelect.append("FROM " + Comment.class.getName() + " a ");
        strSqlSelect.append("LEFT OUTER JOIN " + User.class.getName() + " b ");
        strSqlSelect.append("ON a.userId = b.id ");
        strSqlSelect.append("WHERE b.id = :userId ");

        TypedQuery<CommentAndUserInfoDto> querySelect = entityManager.createQuery(strSqlSelect.toString(),
                CommentAndUserInfoDto.class);

        // Set parameter data
        querySelect.setParameter("userId", intUserId);

        List<CommentAndUserInfoDto> lstCommentAndUserInfo = querySelect.getResultList();
        return ResponseEntity.ok(lstCommentAndUserInfo);
    }
}
