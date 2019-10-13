package tai.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tai.example.demo.constant.ServiceArticleConst;
import tai.example.demo.form.ArticleForm;
import tai.example.demo.form.BaseSearchForm;
import tai.example.demo.form.RequestListArticlesForm;
import tai.example.demo.model.Article;
import tai.example.demo.services.ServiceArticleService;

/**
 * Controller Articles
 *
 * @author TuMV
 */
@Controller
@RequestMapping(ServiceArticleConst.BASE_API_ARTICLE_URL)
public class ArticleController {

    @Autowired
    private ServiceArticleService serviceArticleService;

    /**
     * Get all articles
     *
     * @author TuMV
     * @return all articles
     */
    @GetMapping(ServiceArticleConst.BASE_API_GET_ARTICLE_URL)
    public ResponseEntity<?> getAllArticles() {
        return serviceArticleService.getAllArticle();
    }

    /**
     * Create new articles
     *
     * @author TuMV
     * @param articleForm
     * @return status success or fail
     * @throws Exception
     */
    @PostMapping(ServiceArticleConst.BASE_API_ADD_ARTICLE_URL)
    public ResponseEntity createArticle(@RequestBody ArticleForm articleForm) throws Exception{
        Article article = new Article();
        article.setTitle(articleForm.getTitle());
        article.setCategory(articleForm.getCategory());
        article.setUserId(articleForm.getUserId());
        if (serviceArticleService.addArticle(article)) {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Get list articles with form data
     *
     * @author TuMV
     * @param form
     * @param result
     * @return all articles mapping vs form data
     */
    @GetMapping(ServiceArticleConst.BASE_API_GET_LIST_ARTICLE_URL)
    public ResponseEntity<?> getListArticles(@Validated @RequestBody BaseSearchForm<RequestListArticlesForm> form,
                                             BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        return serviceArticleService.getCurrentPage(form);
    }

    /**
     * Delete article by id and flag
     *
     * @author TuMV
     * @param articleId
     * @param flagDel
     * @return
     */
    @DeleteMapping(ServiceArticleConst.BASE_API_DELETE_ARTICLE_URL)
    @Transactional
    public ResponseEntity deleteArticle(@RequestParam int articleId, @RequestParam int flagDel) {
        try {
            serviceArticleService.deleteArticle(articleId, flagDel);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
