package tai.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Pagination
 *
 * @author TuMV
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {

    @NotNull
    @Min(0)
    private int currentPage;

    @NotNull
    @Min(0)
    private int itemsPerPage;

    @NotNull
    @Min(0)
    private Long totalItemCount;
}
