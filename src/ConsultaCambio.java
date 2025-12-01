import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {
    public static Conversion conversionMoneda (String monedaBase, String monedaDestino, double cantidad){

        String clave = "7601996034dcd4b5df98802a";

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ clave + "/pair/" + monedaBase + "/" + monedaDestino + "/" + cantidad);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> respuesta = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(respuesta.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro esa moneda.");
        }
    }
}
