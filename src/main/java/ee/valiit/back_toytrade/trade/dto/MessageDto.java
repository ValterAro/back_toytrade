package ee.valiit.back_toytrade.trade.dto;

import ee.valiit.back_toytrade.domain.message.Message;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * A DTO for the {@link Message} entity
 */
@Data
public class MessageDto implements Serializable {
    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    @Size(max = 255)
    @NotNull
    private String message;
    @Size(max = 2)
    @NotNull
    private String status;
    private Instant created_at;
}