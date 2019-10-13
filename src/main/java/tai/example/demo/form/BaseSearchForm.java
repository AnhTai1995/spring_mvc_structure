package tai.example.demo.form;

import lombok.Data;
import tai.example.demo.response.Pagination;

/**
 * Form for mapping request's param
 *
 * @author TuMV
 * @param <T>
 */
@Data
public class BaseSearchForm<T> {
    private Pagination pagination;
    private T queries;
}
