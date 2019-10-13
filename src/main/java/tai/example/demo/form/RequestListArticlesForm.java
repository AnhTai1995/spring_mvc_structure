package tai.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Form data request
 *
 * @author TuMV
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestListArticlesForm {
    private int userId;
}
