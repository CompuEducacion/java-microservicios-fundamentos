package trader.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import trader.BrokerException;
import trader.BrokerModel;
import trader.BrokerModelImpl;
import trader.Stock;

@ManagedBean(name="stocks")
@RequestScoped
public class StocksManagedBean {

    private BrokerModel model = BrokerModelImpl.getInstance();

    private String message = "";
    
    /** Creates a new instance of StocksManagedBean */
    public StocksManagedBean() {
    }

    public String getMessage() {
        return message;
    }

    public Stock[] getAllStocks() {
        Stock[] stocks = null;
        try {
            stocks = model.getAllStocks();
        } catch (BrokerException be) {
            message = be.getMessage();
        }
        return stocks;
    }

}
