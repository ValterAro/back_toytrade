package ee.valiit.back_toytrade.trade.dto;

import ee.valiit.back_toytrade.domain.condition.Condition;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Condition} entity
 */
@Data
public class ConditionDto implements Serializable {
    private Integer conditionId;
    @Size(max = 255)
    @NotNull
    private String conditionName;
}