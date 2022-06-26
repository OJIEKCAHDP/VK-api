package ojiekcahdp.vk.bot.dev.vk.api.methods.messages;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

import java.io.IOException;
import java.net.URL;

@Setter
@Getter
@Accessors(chain = true)
public class removeChatUser {

    private int chatId;
    private int userId;
    private int memberId;
    protected Bot bot;

    public removeChatUser(Bot bot) {
        this.bot = bot;
    }

    public void execute() {

        String request = "https://api.vk.com/method/messages.removeChatUser?";

        if (userId > 0) {
            request += "user_id=" + userId + "&";
        }

        if (memberId != 0) {
            request += "member_id=" + memberId + "&";
        }

        request += "&v=" + bot.getApi_version() + "&access_token=" + bot.getAccessToken();

        try {
            new URL(request).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
