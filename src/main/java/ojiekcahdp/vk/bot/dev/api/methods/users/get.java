package ojiekcahdp.vk.bot.dev.vk.api.methods.users;

import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;
import ojiekcahdp.vk.bot.dev.vk.api.methods.users.response.GetResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class get {

    private String[] user_ids;
    private String[] fields;
    private String nameCase;
    private Bot bot;

    public get(Bot bot) {
        this.bot = bot;
    }

    public get setUserIds(String ...user_ids) {
        this.user_ids = user_ids;
        return this;
    }

    public get setFields(String ...fields) {
        this.fields = fields;
        return this;
    }

    public GetResponse execute() {
        if (user_ids.length == 0) return null;

        String method = "user_ids=" + String.join(",", user_ids) + "&";

        if (fields != null && fields.length > 0) {
            method += "fields=" + String.join(",", fields) + "&";
        }
        method += "v=" + bot.getApi_version() + "&access_token=" + bot.getAccessToken();

        String response = "";

        try {
            URL url = new URL("https://api.vk.com/method/users.get?" + method.replace(" ", "%20"));
            response = new BufferedReader(new InputStreamReader(url.openStream())).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GetResponse(response);

    }

}
