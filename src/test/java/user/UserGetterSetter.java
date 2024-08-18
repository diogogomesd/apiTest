package user;

import com.google.gson.Gson;
import org.json.JSONObject;

public class UserGetterSetter {
    private String email;
    private String gender;
    private String name;
    private String status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JSONObject getJson() {

        return new JSONObject(new Gson().toJson(this));
    }
}
