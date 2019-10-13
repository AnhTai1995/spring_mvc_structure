package tai.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for get comment and user info
 *
 * @author TuMV
 */
@Data
@NoArgsConstructor
public class CommentAndUserInfoDto {

    private String content;

    private String userName;

    private int age;

    public CommentAndUserInfoDto(String content, String userName, int age) {
        this.content = content;
        this.userName = userName;
        this.age = age;
    }
}
