package steps;

import api.ApiUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import utils.PropertiesUtils;

public class GorestSteps extends ApiUtils {

    PropertiesUtils prop = new PropertiesUtils();

    @Dado("que passou gorest token valido")
    public void que_passou_gorest_token_valido() {
        token = prop.getProp("token_gorest");
    }
    @Quando("envio uma request de cadastro de usuario com dados validos")
    public void envio_uma_request_de_cadastro_de_usuario_com_dados_validos() {

    }
    @Entao("o usuario deve criado corretamente")
    public void o_usuario_deve_criado_corretamente() {

    }
    @Entao("o status code deve ser {int}")
    public void o_status_code_deve_ser(Integer int1) {

    }

}
