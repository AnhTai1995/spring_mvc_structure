package tai.example.demo.services;

import org.springframework.scheduling.annotation.Async;
import tai.example.demo.model.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Service user interface
 *
 * @author TuMV
 */
public interface ServiceUserService {
    /**
     * Get all user from github with async
     *
     * @author TuMV
     * @return list user
     */
    @Async
    CompletableFuture<User> getAllUserOnGitHub(String strUser);

    /**
     * Get user without async
     *
     * @author TuMV
     * @param strUser
     * @return User
     */
    User getAllUserOnGitHubNonAsync(String strUser);

    /**
     * Add new user
     *
     * @author TuMV
     * @param user
     */
    void addNewUser(User user);

    /**
     * Get all user from github with multiple async
     *
     * @author TuMV
     * @return list user
     */
    List<User> getAllUserOnGitHubMuilpleAsync(String[] strUser) throws ExecutionException, InterruptedException;

    /**
     * Test multiple async in same class
     *
     * @author TuMV
     */
    void getMultipleAsyncSameClass();

    /**
     * Test multiple async normal
     *
     * @author TuMV
     */
    @Async
    void getMultipleAsync();
}