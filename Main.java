import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args){
        try {
        URL url = new URL("http://localhost:8080/Bodegas");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine() )!= null){
                response.append(line);
            }

            reader.close();

            System.out.println("Respuesta de la API: " + response.toString());

            connection.disconnect();

            } else {
            throw new RuntimeException("Error al conectarnos a la api: "+ responseCode);
        }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
