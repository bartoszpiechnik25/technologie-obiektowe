import java.util.HashMap;
import java.util.NoSuchElementException;

public class CurrencyCollection {
    private HashMap<String, Currency> collection;

    public CurrencyCollection(){
        collection = new HashMap<>();
    }
    public void add(Currency currency) {
        collection.put(currency.getCurrencyCode(), currency);
    }

    public void add(String code, String name, Integer conversionFactor, Double exchangeRate) {
        Currency newCurrency = new Currency(code, name, conversionFactor, exchangeRate);
        add(newCurrency);
    }

    public Currency get(String code) {
        if (!collection.containsKey(code))
            throw new NoSuchElementException("Currency with code: " + code + " does not exist!");
        return collection.get(code);
    }

//    public void update(String code) {
//        if (!collection.con)
//    }
}
