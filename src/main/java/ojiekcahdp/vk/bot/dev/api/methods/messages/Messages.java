package ojiekcahdp.vk.bot.dev.vk.api.methods.messages;

import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

public class Messages {

    private Bot bot;

    public Messages(Bot bot) {
        this.bot = bot;
    }

    public send send() {
        return new send(bot);
    }

    public delete delete() {
        return new delete(bot);
    }

    public removeChatUser removeChatUser() {
        return new removeChatUser(bot);
    }

}
