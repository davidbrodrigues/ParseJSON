import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EjemploParse {
    public static void main(String args[]) throws URISyntaxException, IOException, InterruptedException {

        // creamos la petición
        HttpRequest request = HttpRequest.newBuilder()
                //desde donde me traigo el json
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                //un metodo para trerme cosas
                .GET()
                //constriumos la vaina
                .build();

        // creamos el cliente con el siguiente metodo de la clase httpclient que viene siendo un builder y me devuelve un htttpClient
        HttpClient client = HttpClient.newHttpClient();

        // El cliuente envia la petición a esa uri y obtenemos la respuesta en este caso esta especificado un string, y lo va a guardar en un objeto httpresponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Mostramos el cuerpo de la respuesta con un sout
        System.out.println(response.body());

        /*String cadenaJSON = "";
        JSONObject obj = new JSONObject(cadenaJSON);
        String vivo = obj.getJSONObject("pageInfo").getString("pageName");
        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
        System.out.println(vivo);*/
    }
}