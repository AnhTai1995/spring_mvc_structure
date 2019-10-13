package tai.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public ResponseEntity<?> greeting(@RequestParam(value="name", defaultValue="World") String name) {


        return new ResponseEntity<>(name,HttpStatus.OK);
    }
}
