package ojiekcahdp.vk.bot.dev.vk.api.methods.groups;

import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;
import ojiekcahdp.vk.bot.dev.vk.api.longpoll.LongPollServer;

public class Groups {

    private Bot bot;

    public Groups(Bot bot) {
        this.bot = bot;
    }

    public LongPollServer getLongPollServer() {

        return LongPollServer.get(bot);

    }

}
