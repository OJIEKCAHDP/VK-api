package ojiekcahdp.vk.bot.dev.vk.api.utils;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import ojiekcahdp.vk.bot.dev.vk.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

public class Jsonner {

    public static Message getMessage(String json, int index) {

        if (Integer.parseInt(JsonPath.read(json, "updates.length()").toString()) < 1 && Integer.parseInt(JsonPath.read(json, "updates.length()").toString()) < index) {
            return null;
        }

        int size = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.fwd_messages.length()").toString());

        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            long date = Long.parseLong(JsonPath.read(json, "updates[" + index + "].object.message.fwd_messages[" + i + "].date").toString());
            int fromId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.fwd_messages[" + i + "].from_id").toString());
            int id = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.fwd_messages[" + i + "].id").toString());
            int peerId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.fwd_messages[" + i + "].peer_id").toString());
            String text = JsonPath.read(json, "updates[" + index + "].object.message.fwd_messages[" + i + "].text").toString();
            int conversationMessageId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.fwd_messages[" + i + "].conversation_message_id").toString());
            messages.add(new Message(date, fromId, id, 0, peerId, text, conversationMessageId, new ArrayList<>(), null));

        }

        Message reply;

        try {
            long date = Long.parseLong(JsonPath.read(json, "updates[" + index + "].object.message.reply_message.date").toString());
            int fromId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.reply_message.from_id").toString());
            int id = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.reply_message.id").toString());
            int peerId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.reply_message.peer_id").toString());
            String text = JsonPath.read(json, "updates[" + index + "].object.message.reply_message.text").toString();
            int conversationMessageId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.reply_message.conversation_message_id").toString());
            reply = new Message(date, fromId, id, 0, peerId, text, conversationMessageId, new ArrayList<>(), null);
        } catch (PathNotFoundException e) {
            reply = null;
        }

        long date = Long.parseLong(JsonPath.read(json, "updates[" + index + "].object.message.date").toString());
        int fromId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.from_id").toString());
        int id = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.id").toString());
        int out = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.out").toString());
        int peerId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.peer_id").toString());
        String text = JsonPath.read(json, "updates[" + index + "].object.message.text").toString();
        int conversationMessageId = Integer.parseInt(JsonPath.read(json, "updates[" + index + "].object.message.conversation_message_id").toString());

        return new Message(date, fromId, id, out, peerId, text, conversationMessageId, messages, reply);
    }

    private static boolean exception(String json, String path) {
        try {
            JsonPath.read(json, path);
            return false;
        } catch (PathNotFoundException e) {
            return true;
        }
    }

}
