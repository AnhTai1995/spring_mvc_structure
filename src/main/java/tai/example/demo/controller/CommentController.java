package tai.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tai.example.demo.constant.ServiceCommentConst;
import tai.example.demo.services.ServiceCommentService;

/**
 * Comments Controller
 *
 * @author TuMV
 */
//@RestController(ServiceArticleConst.BASE_API_COMMENT_URL)
@Controller
@RequestMapping(ServiceCommentConst.BASE_API_COMMENT_URL)
public class CommentController {

    @Autowired
    private ServiceCommentService serviceCommentService;

    /**
     * Get all comments
     *
     * @author TuMV
     * @return all comments
     */
    @GetMapping(ServiceCommentConst.BASE_API_GET_ALL_COMMENT_URL)
    public ResponseEntity<?> getAllComment() {
        return ResponseEntity.ok(serviceCommentService.getAllComment());
    }

    /**
     * Get comment by id
     *
     * @author TuMV
     * @param id
     * @return comment
     */
    @GetMapping(ServiceCommentConst.BASE_API_GET_COMMENT_URL)
    public ResponseEntity<?> getCommentAndArticleInfo(@RequestParam int id) {
        System.out.println(id);
        return ResponseEntity.ok(serviceCommentService.getCommentByUserId(id));
    }
}
