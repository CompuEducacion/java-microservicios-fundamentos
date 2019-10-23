package webservicetester;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StockPriceService service = new StockPriceService();
        StockPrice port = service.getStockPricePort();
        System.out.println("Stock price is: " + port.getStockPrice("ORCL"));
    }
}
