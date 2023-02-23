package ee.valiit.back_toytrade.domain.message;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Resource
    private MessageRepository messageRepository;

    public void addMessage(Message message) {


        messageRepository.save(message);


    }

    public List<Message> findMessages(Integer senderId, Integer receiverId) {
        List<Message> messages = messageRepository.findMessages(senderId, receiverId);
        return messages;

    }
    public List<Message> findReceiverMessages(Integer receiverId) {
        List<Message> messages = messageRepository.findReceiverMessages(receiverId);
        return messages;

    }




    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
