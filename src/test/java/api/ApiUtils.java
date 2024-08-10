package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiUtils extends LogUtils{
    protected static Response response;
    protected static JSONObject body;
    protected static String uri;
    protected static Map<String, String> headers = new HashMap<>();
    protected static Map<String, String> params = new HashMap<>();
    protected static String token;

    public void log(String verb){
        super.logInfo(" ********** Dados enviados na request **********");
        super.logInfo(verb+" "+uri);
        super.logInfo("body: \n"+body);
        super.logInfo("Headers: "+headers);
        super.logInfo("Params: "+params);

        super.logInfo(" ********** Dados recebidos na response **********");
        super.logInfo("Status code: "+response.statusCode());
        super.logInfo("Payload recebido: \n"+response.asPrettyString());
        super.logInfo("Tempo de resposta: "+response.timeIn(TimeUnit.MILLISECONDS));
    }
}
