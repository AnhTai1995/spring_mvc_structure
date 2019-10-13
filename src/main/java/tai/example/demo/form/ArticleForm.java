package tai.example.demo.form;

import lombok.Data;

/**
 * Article form to mapping request's param
 *
 * @author TuMV
 */
@Data
public class ArticleForm {

    private String title;

    private String category;

    private int userId;
}
