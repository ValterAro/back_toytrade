package ee.valiit.back_toytrade.trade.dto;

import ee.valiit.back_toytrade.domain.category.Category;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private Integer categoryId;
    private String categoryName;
    private Boolean isSelected = false;
}