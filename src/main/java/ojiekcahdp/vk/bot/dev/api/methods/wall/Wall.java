package ojiekcahdp.vk.bot.dev.vk.api.methods.wall;

import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

public class Wall {

    private Bot bot;

    public Wall(Bot bot) {
        this.bot = bot;
    }

    public post post() {
        return new post(this.bot);
    }

}
