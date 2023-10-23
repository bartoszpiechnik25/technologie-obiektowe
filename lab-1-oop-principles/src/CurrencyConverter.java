
public class CurrencyConverter {
    private final Currency currency1;
    private final Currency currency2;

    private final double amount;

    public CurrencyConverter(Currency currency1, Currency currency2, double amount) {
        this.amount = amount;
        this.currency1 = currency1;
        this.currency2 = currency2;
    }
    public double convert() {
        return (amount * currency1.getExchangeRate() * currency2.getConversionFactor()) / (currency2.getExchangeRate() * currency1.getConversionFactor());
    }
}

