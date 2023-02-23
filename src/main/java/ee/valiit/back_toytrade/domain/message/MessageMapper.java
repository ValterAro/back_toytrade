package ee.valiit.back_toytrade.domain.message;

import ee.valiit.back_toytrade.trade.dto.MessageDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MessageMapper {




    @Mapping(source = "created_at", target = "createdAt")
    Message toEntity(MessageDto messageDto);


    @Mapping(source = "sender.id", target = "senderId")
    @Mapping(source = "receiver.id", target = "receiverId")
    @Mapping(source = "createdAt", target = "created_at")
    MessageDto toDto(Message message);
    List<MessageDto> toDtos(List<Message> messages);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Message partialUpdate(MessageDto messageDto, @MappingTarget Message message);
}