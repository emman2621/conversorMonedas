package modelo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public JsonObject buscarMoneda(String code){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/acadac4323f03c3349b4cad4/latest/"+code);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();
            return root.getAsJsonObject("conversion_rates");
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda");
        }

    }
}
