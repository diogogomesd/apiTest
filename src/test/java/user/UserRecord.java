package user;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

public record UserRecord(String email, String name, String gender, String status) {

    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }
    public String getXml() {
        return XML.toString(getJson());
    }
}
