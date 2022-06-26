package ojiekcahdp.vk.bot.dev.vk.api.longpoll;

import com.jayway.jsonpath.JsonPath;
import lombok.Getter;
import lombok.experimental.Accessors;
import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LongPollServer {

    @Getter
    @Accessors(chain = true)
    private int ts;
    @Getter
    @Accessors(chain = true)
    private String server;
    @Getter
    @Accessors(chain = true)
    private String key;
    @Getter
    private Bot bot;

    public LongPollServer(Bot bot, String server, String key, int ts) {
        this.server = server;
        this.ts = ts;
        this.key = key;
        this.bot = bot;
    }

    public LongPollRequest request() {
        return new LongPollRequest(this);
    }

    public static LongPollServer get(Bot vkBot) {

        BufferedReader in = null;

        try {
            URL url = new URL("https://api.vk.com/method/groups.getLongPollServer?access_token=" + vkBot.getAccessToken() + "&group_id=" + vkBot.getGroupId() + "&v=" + vkBot.getApi_version());
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String response = null;
        try {
            response = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ts = Integer.parseInt(JsonPath.read(response, "response.ts").toString());
        String key = JsonPath.read(response, "response.key").toString();
        String server = JsonPath.read(response, "response.server").toString();

        return new LongPollServer(vkBot, server, key, ts);

    }

}
