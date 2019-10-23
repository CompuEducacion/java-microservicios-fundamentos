package trader;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {

    @Id
    @Column(name = "SYMBOL")
    private String symbol;
    @Column(name = "PRICE")
    private double price;
    @Version
    @Column(name = "VERSION")
    private int version = 1;

    public Stock() {
    }

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public Stock(String symbol, double price, int version) {
        this(symbol, price);
        this.version = version;
    }

    // Methods to return the private values of this object
    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public int getVersion() {
        return version;
    }

    public String toString() {
        return "Stock:  " + symbol + "  " + price;
    }
}
