import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestHandler {
    public static RequestHandler requestHandler = null;

    private RequestHandler() {}

    public static RequestHandler getInstace() {
        if (requestHandler == null)
            requestHandler = new RequestHandler();
        return requestHandler;
    }

    public String get(String url) {
        String requestContent = "";
        try {
            URL urlObject = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            BufferedReader content = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();

            String inputLine;
            while ((inputLine = content.readLine()) != null) {
                response.append(inputLine);
            }
            requestContent = response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestContent;
    }

}
