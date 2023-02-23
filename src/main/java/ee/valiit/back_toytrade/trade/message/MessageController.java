package ee.valiit.back_toytrade.trade.message;

import ee.valiit.back_toytrade.trade.dto.MessageDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Resource
    private MessagesService messagesService;


    @PostMapping("/message")
    @Operation(summary = "adds new message to database", description = "adds message by receiverId and senderId")
    public void addMessage (@RequestBody MessageDto messageDto) {
        messagesService.addMessage(messageDto);
    }
    @GetMapping("/message")
    @Operation(summary = "gets messages by users id", description = "gets all messages by user")
    public List<MessageDto> findMessages (@RequestParam Integer senderId, @RequestParam Integer receiverId) {

       return messagesService.findMessages(senderId, receiverId);
    }
    @PutMapping("/message/change")
    @Operation(summary = "updates message status", description = "changes message's status from A to D")
    public void editMessageStatus(@RequestParam Integer receiverId, @RequestParam Integer senderId) {
        messagesService.editMessageStatus(receiverId, senderId);
    }

    @GetMapping("/message/received")
    @Operation(summary = "gets all messages sent to user", description = "gets messages by receiver id")
    public List<MessageDto> findMessages (@RequestParam Integer receiverId) {

        return messagesService.findReceiverMessages(receiverId);
    }
}
