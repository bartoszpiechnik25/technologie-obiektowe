import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RequestHandler handler = RequestHandler.getInstance();
        try {
            InputStream data = handler.get("https://www.nbp.pl/kursy/xml/lasta.xml");
            List<Map<XMLParser.CurrencyAttr, String>> parsed = XMLParser.parse(data);
            CurrencyCollection currencyCollection = CollectionInitializer.initialize(parsed);
            System.out.println(currencyCollection);
        } catch (Exception io) {
            io.printStackTrace();
        }
    }
}
