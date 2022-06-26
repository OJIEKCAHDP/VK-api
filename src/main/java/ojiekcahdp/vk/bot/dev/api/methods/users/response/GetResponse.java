package ojiekcahdp.vk.bot.dev.vk.api.methods.users.response;

import com.jayway.jsonpath.JsonPath;

public class GetResponse {

    private String response;

    public GetResponse(String response) {
        this.response = response;
    }

    public String getFirstName(int index) {

        if (Integer.parseInt(JsonPath.read(response, "response.length()").toString()) < index + 1) {

            return "";

        } else {

            return JsonPath.read(response, "response[" + index+ "].first_name");

        }

    }

    public String getLastName(int index) {

        if (Integer.parseInt(JsonPath.read(response, "response.length()").toString()) < index + 1) {

            return "";

        } else {

            return JsonPath.read(response, "response[" + index+ "].last_name");

        }

    }

    public String getField(int index, String field) {

        if (field.isEmpty()) return "";

        if (Integer.parseInt(JsonPath.read(response, "response.length()").toString()) < index + 1) {

            return "";

        } else {

            return JsonPath.read(response, "response[" + index+ "]." + field);

        }

    }

}
