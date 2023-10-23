import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CurrencyCollection {
    private final HashMap<String, Currency> collection;

    public CurrencyCollection(){
        collection = new HashMap<>();
    }
    public void add(Currency currency) {
        collection.put(currency.getCurrencyCode(), currency);
    }
    public void add(@NotNull Map<XMLParser.CurrencyAttr, String> data) {
        collection.put(data.get(XMLParser.CurrencyAttr.CODE), new Currency(data));
    }
    public Currency get(String code) throws NoSuchElementException {
        if (!collection.containsKey(code))
            throw new NoSuchElementException("Currency with code: " + code + " does not exist!");
        return collection.get(code);
    }

    public void update(String code, Currency newCurrencyData) throws NoSuchElementException {
        if (!collection.containsKey(code))
            throw new NoSuchElementException("Currency with code: " + code + " does not exist!");
        collection.replace(code, newCurrencyData);
    }
    public Currency remove(String code) {
        return collection.remove(code);
    }
    public boolean contains(String code) {
        return collection.containsKey(code);
    }
    @Override
    public String toString() {
        return collection.toString();
    }
}
