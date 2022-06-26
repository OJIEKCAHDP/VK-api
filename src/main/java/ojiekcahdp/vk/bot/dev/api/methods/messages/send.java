package ojiekcahdp.vk.bot.dev.vk.api.methods.messages;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

@Getter
@Setter
@Accessors(chain = true)
public class send {

    private int userId;
    private int random = new Random().nextInt(10000);
    private int peerId;
    private int[] peerIds;
    private String domain;
    private int chatId;
    private String message;
    private int replyTo;
    private int[] forwardMessages;
    private String forward;
    private int stickerId;
    private int groupId;
    private boolean notParseLinks;
    private boolean disableMentions;
    private Bot bot;

    public send(Bot bot) {
        this.bot = bot;
    }

    public send setForward(long peerId, int[] conversationMessageIds, boolean reply) {
        forward = "";
        String isReply = (reply ? "1" : "0");
        forward += "{\"peer_id\":" + peerId + ",\"conversation_message_ids\":[" + String.join(",", (CharSequence) Collections.singletonList(conversationMessageIds)) + "],\"is_reply\":" + isReply + "}";
        return this;
    }

    public send setForward(long peerId, int conversationMessageId, boolean reply) {
        forward = "";
        String isReply = (reply ? "1" : "0");
        forward += "{\"peer_id\":" + peerId + ",\"conversation_message_ids\":[" + conversationMessageId + "],\"is_reply\":" + isReply + "}";
        return this;
    }

    public void execute() {

        String request = "https://api.vk.com/method/messages.send?";

        if (userId > 0) {
            request += "user_id=" + userId + "&";
        }

        if (peerId > 0) {
            request += "peer_id=" + peerId + "&";
        }

        if (peerIds != null) {
            request += "peer_ids=" + String.join(",", (CharSequence) Arrays.asList(peerIds)) + "&";
        }

        if (domain != null) {
            request += "domain=" + domain + "&";
        }

        if (chatId > 0) {
            if (chatId < 100000000) {
                request += "chat_id=" + chatId + "&";
            } else
                request += "peer_id=" + chatId + "&";
        }

        if (message != null) {
            request += "message=" + message.replace(" ", "%20").replace("\n", "%0A") + "&";
        }

        if (replyTo > 0) {
            request += "reply_to=" + replyTo + "&";
        }

        if (forwardMessages != null) {
            request += "forward_messages=" + String.join(",", (CharSequence) Arrays.asList(forwardMessages)) + "&";
        }

        if (forward != null) {
            request += "forward=" + forward + "&";
        }

        if (stickerId > 0) {
            request += "sticker_id=" + stickerId + "&";
        }

        if (groupId > 0) {
            request += "group_id=" + groupId + "&";
        }

        if (notParseLinks) {
            request += "dont_parse_links=1&";
        }

        if (disableMentions) {
            request += "disable_mentions=1&";
        }

        request += "random_id=" + random + "&v=" + bot.getApi_version() + "&access_token=" + bot.getAccessToken();

        if (bot.getGroupId() > 0) {
            request += "&group_id=" + bot.getGroupId();
        }

        try {
            System.out.println(new BufferedReader(new InputStreamReader(new URL(request).openStream())).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
