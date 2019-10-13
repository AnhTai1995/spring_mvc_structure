package tai.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Article DTO
 *
 * @author TuMV
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private String title;

    private String category;

    private String userName;

    private int age;

}
