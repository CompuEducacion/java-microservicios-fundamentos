package trader.web;

import javax.naming.InitialContext;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import trader.BrokerModel;
import trader.Stock;

@Path("stocks/{symbol}")
public class StockResource {

    @Context
    private UriInfo context;

    /** Creates a new instance of StockResource */
    public StockResource() {
    }

    /**
     * Retrieves representation of an instance of trader.web.StockResource
     * @param symbol resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getStockPrice(@PathParam("symbol") String symbol) {
        try {
            javax.naming.Context ctx = new InitialContext();
            BrokerModel model = (BrokerModel)ctx.lookup("java:global/BrokerTool/BrokerModelImpl");
            Stock stock = model.getStock(symbol);
            return String.valueOf(stock.getPrice());
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Price unavailable";
        }
    }
}