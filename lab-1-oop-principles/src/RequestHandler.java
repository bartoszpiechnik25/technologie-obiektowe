import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class RequestHandler {
    public static RequestHandler requestHandler = null;

    private RequestHandler() {}

    public static RequestHandler getInstance() {
        if (requestHandler == null)
            requestHandler = new RequestHandler();
        return requestHandler;
    }

    public InputStream get(String url) throws IOException, InterruptedException, UncheckedIOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new IOException("GET request failed with status code: " + response.statusCode());
        return response.body();
    }

}
