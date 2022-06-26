package ojiekcahdp.vk.bot.dev.vk.api.longpoll;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import lombok.Getter;
import ojiekcahdp.vk.bot.dev.Commands.Command;
import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;
import ojiekcahdp.vk.bot.dev.vk.api.objects.Message;
import ojiekcahdp.vk.bot.dev.vk.api.utils.Jsonner;

public class LongPollResponse {

    @Getter
    private String response;

    public LongPollResponse(Bot bot, String response) {
        this.response = response;
        if (!JsonPath.read(response, "updates").toString().replace("[]", "").isEmpty()) {
            int index = 0;
            do {
                switch (JsonPath.read(response, "updates[" + index + "].type").toString()) {
                    case "message_new": {
                        int finalIndex = index;
                        Message message = Jsonner.getMessage(response, finalIndex);
                        bot.getListeners().forEach(listener -> {
                            listener.onNewMessage(message);
                        });
                        Command.onMessage(message);
                        break;
                    }
                }
                index++;
            } while (!exception(response, "updates[" + index + "]") && !JsonPath.read(response, "updates[" + index + "]").toString().replace("[]", "").isEmpty());
        }
    }

    private boolean exception(String json, String path) {
        try {
            JsonPath.read(json, path);
            return false;
        } catch (PathNotFoundException e) {
            return true;
        }
    }

}
