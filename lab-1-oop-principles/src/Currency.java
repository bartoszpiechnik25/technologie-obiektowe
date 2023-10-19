public class Currency {
    private String code;
    private String name;
    private Integer conversionFactor;
    private Double exchangeRate;

    public Currency() {
        code = "";
        name = "";
        conversionFactor = 0;
        exchangeRate = 0.;
    }
    public Currency(String code, String name, Integer conversionFactor, Double exchangeRate) {
        this.code = code;
        this.name = name;
        this.conversionFactor = conversionFactor;
        this.exchangeRate = exchangeRate;
    }

    public void setCurrencyCode(String code) {
        this.code = code;
    }

    public String getCurrencyCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setConversionFactor(Integer conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Integer getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Currency){
            Currency currencyObj = (Currency) obj;
            return this.code.equals(currencyObj.code);
        }
        return false;
    }
}
