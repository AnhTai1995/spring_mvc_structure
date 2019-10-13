package tai.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tai.example.demo.constant.ServiceUserConst;
import tai.example.demo.model.User;
import tai.example.demo.services.ServiceUserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * User Controller
 *
 * @author TuMV
 */
@RestController
@RequestMapping(ServiceUserConst.BASE_API_USER_URL)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ServiceUserService serviceUserService;

    private final RestTemplate restTemplate;

    public UserController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Get all user from github api
     *
     * @author TuMV
     * @return list user
     */
    @GetMapping(ServiceUserConst.BASE_API_GET_ALL_USER_URL)
    public ResponseEntity<List<User>> getAllUser() throws ExecutionException, InterruptedException {
        List<User> lstUser = new ArrayList<>();

        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> userOne = serviceUserService.getAllUserOnGitHub("PivotalSoftware");
        CompletableFuture<User> userTwo = serviceUserService.getAllUserOnGitHub("CloudFoundry");
        CompletableFuture<User> userThree = serviceUserService.getAllUserOnGitHub("Spring-Projects");
        CompletableFuture<User> userOne1 = serviceUserService.getAllUserOnGitHub("PivotalSoftware1");
        CompletableFuture<User> userTwo1 = serviceUserService.getAllUserOnGitHub("CloudFoundry1");
        CompletableFuture<User> userThree1 = serviceUserService.getAllUserOnGitHub("Spring-Projects1");
        CompletableFuture<User> userOne2 = serviceUserService.getAllUserOnGitHub("PivotalSoftware2");
        CompletableFuture<User> userTwo2 = serviceUserService.getAllUserOnGitHub("CloudFoundry2");
        CompletableFuture<User> userThree2 = serviceUserService.getAllUserOnGitHub("Spring-Projects2");

        // Wait until they are all done
        CompletableFuture.allOf(userOne, userTwo, userThree,userOne1, userTwo1, userThree1,userOne2, userTwo2, userThree2).join();


        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));

        // Start the clock again
        start = System.currentTimeMillis();

        User userNonAsyncOne = serviceUserService.getAllUserOnGitHubNonAsync("PivotalSoftware");
        User userNonAsyncTwo = serviceUserService.getAllUserOnGitHubNonAsync("CloudFoundry");
        User userNonAsyncThree = serviceUserService.getAllUserOnGitHubNonAsync("Spring-Projects");
        User userNonAsyncOne1 = serviceUserService.getAllUserOnGitHubNonAsync("PivotalSoftware1");
        User userNonAsyncTwo1 = serviceUserService.getAllUserOnGitHubNonAsync("CloudFoundry1");
        User userNonAsyncThree1 = serviceUserService.getAllUserOnGitHubNonAsync("Spring-Projects1");
        User userNonAsyncOne2 = serviceUserService.getAllUserOnGitHubNonAsync("PivotalSoftware2");
        User userNonAsyncTwo2 = serviceUserService.getAllUserOnGitHubNonAsync("CloudFoundry2");
        User userNonAsyncThree2 = serviceUserService.getAllUserOnGitHubNonAsync("Spring-Projects2");

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));

        // Add all user to list and return
        lstUser.add(userOne.get());
        lstUser.add(userTwo.get());
        lstUser.add(userThree.get());

        return ResponseEntity.ok(lstUser);
    }

    /**
     * Create new user
     *
     * @author TuMV
     * @param user
     * @return status success or fail
     */
    @PostMapping(ServiceUserConst.BASE_API_CREATE_NEW_USER_URL)
    public ResponseEntity createNewUser(@Valid @RequestBody User user) {
        serviceUserService.addNewUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Get list user with multiple Async
     *
     * @author TuMV
     * @return list user
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping(ServiceUserConst.BASE_API_GET_USER_MULTIASYNC_URL)
    public ResponseEntity getUserWithMultiAsync() throws ExecutionException, InterruptedException {
        String[] arrUser = {"CloudFoundry", "PivotalSoftware"};
        // Start the clock
        long start = System.currentTimeMillis();
        List<User> lstUser = serviceUserService.getAllUserOnGitHubMuilpleAsync(arrUser);
        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));

        return  ResponseEntity.ok(lstUser);
    }

    /**
     * Get list user with Async in controller
     *
     * @author TuMV
     * @return list user
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping(ServiceUserConst.BASE_API_GET_USER_IN_CONTROLLER_URL)
    public ResponseEntity getUserWithAsyncInController() throws ExecutionException, InterruptedException {
        List<User> lstUser = new ArrayList<>();

        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> userOne = getAllUserOnGitHub1("PivotalSoftware");
        CompletableFuture<User> userTwo = getAllUserOnGitHub1("CloudFoundry");
        CompletableFuture<User> userThree = getAllUserOnGitHub1("Spring-Projects");
        CompletableFuture<User> userOne1 = getAllUserOnGitHub1("PivotalSoftware1");
        CompletableFuture<User> userTwo1 = getAllUserOnGitHub1("CloudFoundry1");
        CompletableFuture<User> userThree1 = getAllUserOnGitHub1("Spring-Projects1");
        CompletableFuture<User> userOne2 = getAllUserOnGitHub1("PivotalSoftware2");
        CompletableFuture<User> userTwo2 = getAllUserOnGitHub1("CloudFoundry2");
        CompletableFuture<User> userThree2 = getAllUserOnGitHub1("Spring-Projects2");

        // Wait until they are all done
        CompletableFuture.allOf(userOne, userTwo, userThree,userOne1, userTwo1, userThree1,userOne2, userTwo2, userThree2).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));

        // Add all user to list and return
        lstUser.add(userOne.get());
        lstUser.add(userTwo.get());
        lstUser.add(userThree.get());

        return ResponseEntity.ok(lstUser);
    }

    /**
     * Test async in same class
     *
     * @author TuMV
     * @return HTTPStatus OK
     */
    @GetMapping(ServiceUserConst.BASE_API_TEST_MULTIPLR_ASYNC_SAME_CLASS_URL)
    public ResponseEntity testMultipleAsyncSameClass() {
        serviceUserService.getMultipleAsyncSameClass();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Test async normal
     *
     * @author TuMV
     * @return
     */
    @GetMapping(ServiceUserConst.BASE_API_TEST_MULTIPLR_ASYNC_URL)
    public ResponseEntity testMultipleAsync() {
        serviceUserService.getMultipleAsync();
        serviceUserService.getMultipleAsync();
        return ResponseEntity.ok(HttpStatus.OK);
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
            user = restTemplate.getForObject(strUrl, User.class);
            logger.info(" [getAllUserOnGitHub1] Looking up " + strUser);
            Thread.sleep(1000L);
        } catch (Exception e) {
        }
        return CompletableFuture.completedFuture(user);
    }
}
