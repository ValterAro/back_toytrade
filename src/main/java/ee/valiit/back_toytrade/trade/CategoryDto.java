package ee.valiit.back_toytrade.trade;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private final Integer id;
}