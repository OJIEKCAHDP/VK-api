package ojiekcahdp.vk.bot.dev.vk.api.methods.messages;

import lombok.Setter;
import lombok.experimental.Accessors;
import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

import java.io.IOException;
import java.net.URL;

@Setter
@Accessors(chain = true)
public class delete {

    private String[] messageIds;
    private boolean spam;
    private int groupId;
    private boolean deleteForAll;
    private int peerId;
    private String[] conversationMessageIds;

    protected Bot bot;

    public delete(Bot bot) {
        this.bot = bot;
    }

    public void execute() {

        String request = "https://api.vk.com/method/messages.delete?";

        if (peerId > 0) {
            request += "peer_id=" + peerId + "&";
        }

        if (deleteForAll) {
            request += "delete_for_all=1&";
        }

        if (spam) {
            request += "spam=1&";
        }

        if (groupId > 0) {
            request += "group_id=" + groupId + "&";
        }

        if (messageIds != null && messageIds.length > 0) {
            request += "message_ids=" + String.join(",", messageIds) + "&";
        }

        if (conversationMessageIds != null && conversationMessageIds.length > 0) {
            request += "message_ids=" + String.join(",", conversationMessageIds) + "&";
        }

        if (bot.getGroupId() > 0) {
            request += "&group_id=" + bot.getGroupId();
        }

        request += "v=" + bot.getApi_version() + "&access_token=" + bot.getAccessToken();

        try {
            new URL(request).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
