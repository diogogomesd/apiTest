package steps;

import api.ApiHeaders;
import api.ApiRequest;
import api.ApiUtils;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import org.junit.Assert;
import user.User;
import user.UserGetterSetter;
import user.UserLombok;
import user.UserRecord;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GorestSteps extends ApiRequest {

    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();


    @Dado("que passou gorest token valido")
    public void que_passou_gorest_token_valido() {
        token = prop.getProp("token_gorest");
    }
    @Quando("envio uma request de cadastro de usuario com dados validos")
    public void envio_uma_request_de_cadastro_de_usuario_com_dados_validos() throws IOException {
        uri = prop.getProp("uri_gorest");
        headers = apiHeaders.goRestHeaders(token);
//        body = jsonUtils.parseJsonFile("create-Users");
//        body.put("email", faker.internet().emailAddress());
//        body.put("name",faker.name().fullName());
        //body = jsonUtils.updateJson(jsonUtils.parseJsonFile("create-Users"),"email", faker.internet().emailAddress());
        //body =  jsonUtils.setJsonValues(jsonUtils.parseJsonFile("create-Users"), setJsonValues());
        //body = new User(faker.internet().emailAddress(), "female", faker.name().fullName(), "Inactive").getJson();
//        UserGetterSetter users = new UserGetterSetter();
//        users.setEmail(faker.internet().emailAddress());
//        users.setGender("Female");
//        users.setName( faker.name().fullName());
//        users.setStatus("Active");
//        body = users.getJson();
        body = new JSONObject(new Gson().toJson(
                UserLombok.builder()
                    .email(faker.internet().emailAddress())
                    .gender("Male")
                    .name(faker.name().fullName())
                    .status("Active")
                .build()
        ));
//        body = new UserRecord(faker.internet().emailAddress(),
//                faker.name().fullName(), "Male", "Active").getJson();
//        String xml = new UserRecord(faker.internet().emailAddress(),
//                faker.name().fullName(), "Male", "Active").getXml();
                super.POST();
    }
//    private Map<String, String> setJsonValues(){
//        Map<String, String> jsonValues = new HashMap<>();
//        jsonValues.put("email", faker.internet().emailAddress());
//        jsonValues.put("name",faker.name().fullName());
//        return jsonValues;
//    }
    @Entao("o usuario deve criado corretamente")
    public void o_usuario_deve_criado_corretamente() {
        Assert.assertEquals(body.getString("email"), response.jsonPath().get("email"));
        Assert.assertEquals(body.getString("name"), response.jsonPath().get("name"));
    }
    @Entao("o status code deve ser {string}")
    public void o_status_code_deve_ser(String code) {
        int StatusCode = Integer.parseInt(code);
        Assert.assertEquals(StatusCode, response.statusCode());
    }

}
