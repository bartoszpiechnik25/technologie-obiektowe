import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        RequestHandler handler = RequestHandler.getInstace();
        System.out.println(handler.get("https://www.nbp.pl/kursy/xml/lasta.xml"));
    }
}
