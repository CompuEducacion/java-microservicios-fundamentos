package trader.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import trader.BrokerException;
import trader.BrokerModel;
import trader.Stock;

@ManagedBean(name="stocks")
@RequestScoped
public class StocksManagedBean {

    @EJB private BrokerModel model;
    
    /** Creates a new instance of StocksManagedBean */
    public StocksManagedBean() {
    }

    public Stock[] getAllStocks() {
        Stock[] stocks = null;
        try {
            stocks = model.getAllStocks();
        } catch (BrokerException be) {

        }
        return stocks;
    }

}
