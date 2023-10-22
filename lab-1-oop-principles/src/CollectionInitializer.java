import java.util.List;
import java.util.Map;

public class CollectionInitializer {

    public static CurrencyCollection initialize(List<Map<XMLParser.CurrencyAttr, String>> parsedData) {
        CurrencyCollection currencyCollection = new CurrencyCollection();
        for (Map<XMLParser.CurrencyAttr, String> currency : parsedData) {
            currencyCollection.add(currency);
        }
        return currencyCollection;
    }
}
