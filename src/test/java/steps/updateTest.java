package steps;

import org.json.JSONObject;
import org.junit.Test;
import utils.JsonUtils;

import java.io.IOException;

public class updateTest {

    JsonUtils jsonUtils = new JsonUtils();
    @Test
    public void updateJson() throws IOException {
        JSONObject js =  jsonUtils.parseJsonFile("updateForJson");
        System.out.println(js);
        System.out.println(jsonUtils.updateJson(js, "type","testado"));
    }
}
