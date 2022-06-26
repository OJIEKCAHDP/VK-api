package ojiekcahdp.vk.bot.dev.vk.api.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Message {

    private final long date;
    private final int fromId;
    private final int id;
    private final int out;
    private final int peerId;
    private final String text;
    private final int conversationMessageId;
    private final List<Message> forwardMessages;
    private final Message replyMessage;


}
