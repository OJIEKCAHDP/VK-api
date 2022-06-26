package ojiekcahdp.vk.bot.dev.vk.api.longpoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LongPollRequest {

    private LongPollServer server;

    public LongPollRequest(LongPollServer server) {
        this.server = server;
    }

    public LongPollResponse getResponse() {

        BufferedReader in = null;

        String request = "${server}?act=a_check&key=${key}&wait=10&mode=2&ts=${ts}";

        try {
            URL url = new URL(request.replace("${server}", server.getServer()).replace("${key}", server.getKey()).replace("${ts}", String.valueOf(server.getTs())));
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String response = "";
        try {
             response = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new LongPollResponse(server.getBot(), response);

    }

}
