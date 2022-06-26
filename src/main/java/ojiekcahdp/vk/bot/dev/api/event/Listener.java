package ojiekcahdp.vk.bot.dev.vk.api.event;

import ojiekcahdp.vk.bot.dev.vk.api.objects.Message;

public abstract class Listener {
    public abstract void onNewMessage(Message message);
}
