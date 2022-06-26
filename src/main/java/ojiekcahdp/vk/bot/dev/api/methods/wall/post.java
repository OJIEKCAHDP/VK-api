package ojiekcahdp.vk.bot.dev.vk.api.methods.wall;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Setter
@Getter
@Accessors(chain = true)
public class post {

    private Bot bot;
    private int ownerId;
    private boolean fromGroup;
    private String message;
    private String attachments;

    public post(Bot bot) {
        this.bot = bot;
    }

    public void execute() {
        String request = "https://api.vk.com/method/wall.post?";

        if (ownerId != 0) {
            request += "owner_id=" + ownerId + "&";
        }
        if (fromGroup) {
            request += "from_group=1&";
        }
        if (message != null) {
            request += "message=" + (message).replace(" ", "%20").replace("\n", "%0A") + "&";
        }
        if (attachments != null) {
            request += "attachments=" + attachments + "&";
        }

        request += "v=" + bot.getApi_version() + "&access_token=" + bot.getAccessToken();

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
