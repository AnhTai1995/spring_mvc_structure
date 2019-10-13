package tai.example.demo.services.Impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tai.example.demo.dto.ArticleDto;
import tai.example.demo.form.BaseSearchForm;
import tai.example.demo.form.RequestListArticlesForm;
import tai.example.demo.model.Article;
import tai.example.demo.model.User;
import tai.example.demo.response.BaseSearchReponse;
import tai.example.demo.response.Pagination;
import tai.example.demo.services.ServiceArticleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

/**
 * Article service implement article service interface
 *
 * @author TuMV
 */
@Service
public class ServiceArticleServiceImpl implements ServiceArticleService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Get all articles
     *
     * @author TuMV
     * @return list comment
     */
    @Override
    public ResponseEntity<List<Article>> getAllArticle() {
        String strSql;
        strSql = "FROM Article as atcl ORDER BY atcl.articleId";
        List<Article> articleList = (List<Article>) entityManager.createQuery(strSql).getResultList();
        return ResponseEntity.ok(articleList);
    }

    /**
     * Get article by id
     *
     * @author TuMV
     * @param articleId
     * @return article
     */
    @Override
    public ResponseEntity<Article> getArticleById(int articleId) {
        Article article = entityManager.find(Article.class, articleId);
        return ResponseEntity.ok(article);
    }

    /**
     * Create new article
     *
     * @author TuMV
     * @param article
     * @return status success or fail
     * @throws SQLException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addArticle(Article article) throws SQLException {
        try {
            if (entityManager.find(User.class, article.getUserId()) == null) {
                createUser(article);
            }
            entityManager.persist(article);
            return true;
            // Test rollback transactional
            //throw new Exception();
        } catch (Exception ex) {
            throw new SQLException();
        }
    }

    /**
     * Create new user when create new article
     *
     * @author TuMV
     * @param article
     * @throws Exception
     */
    @Override
    public void createUser(Article article) throws Exception {
        int userId = article.getUserId();
        User user = new User();
        // Test rollback transactional
        user.setUserName("test" + userId);
        user.setAge(userId + 18);
        entityManager.persist(user);
        //throw new Exception();
    }

    /**
     * Update information article
     *
     * @author TuMV
     * @param article
     */
    @Override
    public void updateArticle(Article article) {
        Article article_old = entityManager.find(Article.class, article.getArticleId());
        article_old.setTitle(article.getTitle());
        article_old.setCategory(article.getCategory());
        entityManager.flush();
    }

    /**
     * Delete article by id and delete flag
     *
     * @author TuMV
     * @param article
     * @param flgDel
     * @throws Exception
     */
    @Override
    public void deleteArticle(int article, int flgDel) throws Exception{
        Article article1 = entityManager.find(Article.class, article);
        entityManager.remove(article1);
        if (flgDel == 1) {
            throw new Exception();
        }
    }

    /**
     * Get data by pagination
     *
     * @author TuMV
     * @param requestListArticlesForm
     * @return data and request's parameter
     */
    @Override
    public ResponseEntity<BaseSearchReponse> getCurrentPage(BaseSearchForm<RequestListArticlesForm> requestListArticlesForm) {
        StringBuilder strSqlSelect = new StringBuilder();
        StringBuilder strSqlCount = new StringBuilder();
        StringBuilder strSqlCondition = new StringBuilder();
        int strUserId = requestListArticlesForm.getQueries().getUserId();
        Pagination pagination = requestListArticlesForm.getPagination();

        // SQL COUNT
            strSqlCount.append("SELECT COUNT(a.articleId) ");

        // SQL Select
        strSqlSelect.append("SELECT new " + ArticleDto.class.getName() + "(a.title,a.category,b.userName,b.age) ");

        // SQL condition
        strSqlCondition.append("FROM " + Article.class.getName() + " a ");
        strSqlCondition.append("INNER JOIN " + User.class.getName() + " b ");
        strSqlCondition.append("ON a.userId = b.id ");
        strSqlCondition.append("WHERE b.id = :userId ");

        // Append condition to get data and count
        strSqlCount.append(strSqlCondition);
        strSqlSelect.append(strSqlCondition);

        TypedQuery<Long> queryCount = entityManager.createQuery(strSqlCount.toString(), Long.class);
        TypedQuery<ArticleDto> querySelect = entityManager.createQuery(strSqlSelect.toString(), ArticleDto.class);

        // Set parameter
        queryCount.setParameter("userId", strUserId);
        querySelect.setParameter("userId", strUserId);

        //Set count items response
        Long countResultListDB = queryCount.getSingleResult();
        pagination.setTotalItemCount(countResultListDB);

        // Set pagination for query
        if (pagination.getCurrentPage() > 0 && pagination.getItemsPerPage() > 0) {
            Pageable firstPageWithTwoElements = PageRequest.of(pagination.getCurrentPage() - 1, pagination.getItemsPerPage());
            querySelect.setFirstResult((pagination.getCurrentPage() - 1) * firstPageWithTwoElements.getPageSize());
            querySelect.setMaxResults(firstPageWithTwoElements.getPageSize());
        }
        List<ArticleDto> lstArticleDtos = querySelect.getResultList();
        BaseSearchReponse baseSearchReponse = new BaseSearchReponse(pagination, requestListArticlesForm.getQueries(), lstArticleDtos);
        return ResponseEntity.ok(baseSearchReponse);
    }
}
