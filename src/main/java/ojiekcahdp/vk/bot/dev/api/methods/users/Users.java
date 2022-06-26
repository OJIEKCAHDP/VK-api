package ojiekcahdp.vk.bot.dev.vk.api.methods.users;

import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

public class Users {

    private Bot bot;

    public Users(Bot bot) {
        this.bot = bot;
    }

    public get get() {
        return new get(this.bot);
    }

}
