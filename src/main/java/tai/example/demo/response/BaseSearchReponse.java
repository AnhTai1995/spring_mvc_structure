package tai.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Form data to return data and user's request to client
 *
 * @author TuMV
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseSearchReponse {
    private Pagination pagination;
    private Object queries;
    private Object items;
}
