package domain;

import java.util.List;

public class Currency {

    private String currency;
    private String code;
    private List<Rate> rates;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public double getSellingRate() {
        return rates.get(0).getAsk();
    }

}
