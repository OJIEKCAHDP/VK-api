package ojiekcahdp.vk.bot.dev.vk.api.bot;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ojiekcahdp.vk.bot.dev.Commands.Command;
import ojiekcahdp.vk.bot.dev.vk.VK;
import ojiekcahdp.vk.bot.dev.vk.api.event.Listener;
import ojiekcahdp.vk.bot.dev.vk.api.longpoll.LongPollServer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Bot {

    private String accessToken;
    private int user_id;
    private int groupId;
    private String api_version;
    private List<Listener> listeners = new ArrayList<>();
    private List<Command> commands = new ArrayList<>();

    public Bot(String api_version) {
        this.api_version = api_version;
    }

    public void startBot() {

        VK vk = new VK(this);

        new Thread(() -> {
            while (true) {

                // LongPollServer response = vk.getApi().groups().getLongPollServer();

                // response.request().getResponse();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

}
