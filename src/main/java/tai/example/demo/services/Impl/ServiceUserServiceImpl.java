package tai.example.demo.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import tai.example.demo.constant.CommonConst;
import tai.example.demo.model.User;
import tai.example.demo.services.ServiceUserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Service user implement user service interface
 *
 * @author TuMV
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceUserServiceImpl implements ServiceUserService {

    private static final Logger logger = LoggerFactory.getLogger(ServiceUserServiceImpl.class);

    private final RestTemplate restTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public ServiceUserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Get all user in git hub
     *
     * @author TuMV
     * @return list user
     */
    @Override
    @Async
    public CompletableFuture<User> getAllUserOnGitHub(String strUser) {
        String strUrl = String.format("https://api.github.com/users/%s", strUser);
        User user = null;
        try {
            user = restTemplate.getForObject(strUrl, User.class);
            logger.info(" [getAllUserOnGitHub] Looking up " + strUser);
            Thread.sleep(1000L);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(user);
    }

    /**
     * Get all user in git hub
     *
     * @author TuMV
     * @return list user
     */
    @Async
    public CompletableFuture<User> getAllUserOnGitHub1(String strUser) {
        String strUrl = String.format("https://api.github.com/users/%s", strUser);
        User user = null;
        try {
            user =  restTemplate.getForObject(strUrl, User.class);
            logger.info(" [getAllUserOnGitHub1] Looking up " + strUser);
            Thread.sleep(1000L);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(user);
    }

    /**
     * Get all user in git hub
     *
     * @author TuMV
     * @return list user
     */
    @Async
    public CompletableFuture<User> getAllUserOnGitHub2(String strUser) {
        String strUrl = String.format("https://api.github.com/users/%s", strUser);
        User user = null;
        try {
            user =  restTemplate.getForObject(strUrl, User.class);
            logger.info(" [getAllUserOnGitHub2] Looking up " + strUser);
            Thread.sleep(1000L);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(user);
    }

    /**
     * Get all user from github with multiple async
     *
     * @author TuMV
     * @return list user
     */
    @Override
    public List<User> getAllUserOnGitHubMuilpleAsync(String[] strUser) throws ExecutionException, InterruptedException {
        List<User> lstUser = new ArrayList<>();

        // Start the clock
        long start = System.currentTimeMillis();

        // Call multiple method async
        CompletableFuture<User> user = getAllUserOnGitHub1(strUser[0]);
        CompletableFuture<User> user1 = getAllUserOnGitHub2(strUser[0]);
        CompletableFuture<User> user2 = getAllUserOnGitHub1(strUser[0]);
        CompletableFuture<User> user3 = getAllUserOnGitHub2(strUser[1] + "1");
        CompletableFuture<User> user4 = getAllUserOnGitHub1(strUser[1] + "1");
        CompletableFuture<User> user5 = getAllUserOnGitHub2(strUser[1] + "1");
        CompletableFuture<User> user6 = getAllUserOnGitHub1(strUser[0] + "2");
        CompletableFuture<User> user7 = getAllUserOnGitHub2(strUser[0] + "2");
        CompletableFuture<User> user8 = getAllUserOnGitHub2(strUser[0] + "2");

        // Wait until they are all done
        CompletableFuture.allOf(user, user1, user2, user3, user4, user5, user6, user7, user8).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));

        // Add all user to list
        lstUser.add(user.get());
        lstUser.add(user2.get());

        return lstUser;
    }

    /**
     * Create new user
     *
     * @author TuMV
     * @param user
     */
    @Override
    public void addNewUser(User user) {
        entityManager.persist(user);
    }

    /**
     * Get user without async
     *
     * @author TuMV
     * @param strUser
     * @return User
     */
    @Override
    public User getAllUserOnGitHubNonAsync(String strUser) {
        String strUrl = String.format("https://api.github.com/users/%s", strUser);
        User user = null;
        try {
            user = restTemplate.getForObject(strUrl, User.class);
            logger.info(" [getAllUserOnGitHubNonAsync] Looking up " + strUser);
            Thread.sleep(1000L);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return user;
    }

    /**
     * Test multiple Async1
     *
     * @author TuMV
     */
    @Async
    public void testMultipleAsync1() {
        for (int i = 1; i < 100; i++) {
            System.out.println(new Throwable().getStackTrace()[0].getMethodName() + CommonConst.BLANK + i);
        }
    }

    /**
     * Test multiple Async2
     *
     * @author TuMV
     */
    @Async
    public void testMultipleAsync2() {
        for (int i = 1; i < 100; i++) {
            System.out.println(new Throwable().getStackTrace()[0].getMethodName() + CommonConst.BLANK + i);
        }
    }

    /**
     * Test multiple async in same class
     *
     * @author TuMV
     */
    @Override
    public void getMultipleAsyncSameClass() {
        testMultipleAsync1();
        testMultipleAsync2();
    }

    /**
     * Test multiple async normal
     *
     * @author TuMV
     */
    @Override
    @Async
    public void getMultipleAsync() {
        for (int i = 1; i < 100; i++) {
            System.out.println(new Throwable().getStackTrace()[0].getMethodName() + CommonConst.BLANK + i);
        }
    }
}
