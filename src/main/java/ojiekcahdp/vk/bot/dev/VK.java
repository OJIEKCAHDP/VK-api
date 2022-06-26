package ojiekcahdp.vk.bot.dev.vk;

import lombok.Getter;
import lombok.Setter;
import ojiekcahdp.vk.bot.dev.vk.api.Api;
import ojiekcahdp.vk.bot.dev.vk.api.bot.Bot;

@Getter
@Setter
public class VK {

    private Bot bot;

    public VK(Bot groupBot) {
        this.bot = groupBot;
    }

    public Api getApi() {

        return new Api(this);

    }
}
