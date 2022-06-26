package ojiekcahdp.vk.bot.dev.vk.api;

import ojiekcahdp.vk.bot.dev.vk.VK;
import ojiekcahdp.vk.bot.dev.vk.api.methods.groups.Groups;
import ojiekcahdp.vk.bot.dev.vk.api.methods.messages.Messages;
import ojiekcahdp.vk.bot.dev.vk.api.methods.users.Users;
import ojiekcahdp.vk.bot.dev.vk.api.methods.wall.Wall;

public class Api {

    private VK vk;

    public Api(VK vk) {
        this.vk = vk;
    }

    public Groups groups() {
        return new Groups(vk.getBot());
    }

    public Messages messages() {
        return new Messages(vk.getBot());
    }

    public Users users() {
        return new Users(vk.getBot());
    }

    public Wall wall() {
        return new Wall(vk.getBot());
    }

}
