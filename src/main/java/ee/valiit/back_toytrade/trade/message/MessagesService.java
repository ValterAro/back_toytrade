package ee.valiit.back_toytrade.trade.message;

import ee.valiit.back_toytrade.domain.message.Message;
import ee.valiit.back_toytrade.domain.message.MessageMapper;
import ee.valiit.back_toytrade.domain.message.MessageRepository;
import ee.valiit.back_toytrade.domain.message.MessageService;
import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.domain.user.UserService;
import ee.valiit.back_toytrade.trade.dto.MessageDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class MessagesService {

    @Resource
    private MessageService messageService;
    @Resource
    private UserService userService;
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private MessageRepository messageRepository;

    public MessagesService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(MessageDto messageDto) {

        Message message = messageMapper.toEntity(messageDto);
        Integer receiverId = messageDto.getReceiverId();
        Integer senderId = messageDto.getSenderId();
        User userReceiver = userService.findUser(receiverId);
        User userSender = userService.findUser(senderId);
        message.setReceiver(userReceiver);
        message.setSender(userSender);
        messageService.addMessage(message);
    }

    public List<MessageDto> findMessages(Integer senderId,Integer receiverId) {


        List<Message> messages = messageService.findMessages(senderId, receiverId);
        List<MessageDto> messageDtos = messageMapper.toDtos(messages);

        return messageDtos;

    }
    public List<MessageDto> findReceiverMessages(Integer receiverId) {


        List<Message> messages = messageService.findReceiverMessages(receiverId);
        List<MessageDto> messageDtos = messageMapper.toDtos(messages);

        return messageDtos;

    }

    public void editMessageStatus(Integer receiverId, Integer senderId) {
        List<Message> messages = messageService.findMessages(receiverId, senderId);
        for (Message message : messages) {
            Instant createdAt = message.getCreatedAt();
            Instant createdAtMinusTwo = createdAt.minus(2,ChronoUnit.HOURS);
            message.setCreatedAt(createdAtMinusTwo);
            message.setStatus("D");
            messageService.saveMessage(message);
        }

    }
}
