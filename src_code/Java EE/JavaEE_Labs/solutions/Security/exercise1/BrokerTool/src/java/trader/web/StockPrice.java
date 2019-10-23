package trader.web;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import trader.BrokerException;
import trader.BrokerModel;
import trader.Stock;

@WebService()
public class StockPrice {
    
    @EJB private BrokerModel model;

    @WebMethod
    public String getStockPrice(String symbol) {
        try {
            Stock stock = model.getStock(symbol);
            return String.valueOf(stock.getPrice());
        } catch (BrokerException ex) {
            return "Price unavailable";
        }
    }

}
