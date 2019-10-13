package tai.example.demo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import tai.example.demo.form.BaseSearchForm;
import tai.example.demo.form.RequestListArticlesForm;
import tai.example.demo.model.Article;
import tai.example.demo.response.BaseSearchReponse;

import java.util.List;

/**
 * Article service interface
 *
 * @author TuMV
 */
@Transactional
public interface ServiceArticleService {

    /**
     * Get all article
     *
     * @author TuMV
     * @return list article
     */
    ResponseEntity<List<Article>> getAllArticle();

    /**
     * Get article by id
     *
     * @author TuMV
     * @param articleId
     * @return Article
     */
    ResponseEntity<Article> getArticleById(int articleId);

    /**
     * Add new article
     *
     * @author TuMV
     * @param article
     * @return
     */
    boolean addArticle(Article article) throws Exception;

    void createUser(Article article) throws Exception;

    /**
     * Update article
     *
     * @author TuMV
     * @param article
     */
    void updateArticle(Article article);

    /**
     * Delete aricle
     *
     * @author TuMV
     * @param article
     * @throws Exception
     */
    void deleteArticle(int article, int flgDel) throws Exception;

    /**
     * Get data currenr page by user id
     *
     * @author TuMV
     * @param requestListArticlesForm
     * @return
     */
    ResponseEntity<BaseSearchReponse> getCurrentPage(BaseSearchForm<RequestListArticlesForm> requestListArticlesForm);

}
