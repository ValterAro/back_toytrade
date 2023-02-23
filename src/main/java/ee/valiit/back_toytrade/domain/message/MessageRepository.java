package ee.valiit.back_toytrade.domain.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("select m from Message m where m.sender.id = ?1 and m.receiver.id = ?2")
    List<Message> findMessages(Integer senderId, Integer receiverId);

    @Query("select m from Message m where m.receiver.id = ?1")
    List<Message> findReceiverMessages(Integer receiverId);





}