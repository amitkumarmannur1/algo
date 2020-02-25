package stocks;

import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.XlsReader;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StockExcel {

    public static void main(String[] asd) throws SpreadsheetReadException {

        final File xlsxFile = new File("C:\\Users\\dmman\\OneDrive\\Desktop\\robinhood.xls");
        final XlsReader reader = new XlsReader();
        List<Stock> employees = reader.read(Stock.class, xlsxFile);
        Map<String, FinalStockPrice> stringFinalStockPriceMap = new LinkedHashMap<>();
        Set<String> listOfStocks = employees.parallelStream().map(Stock::getInstrument).collect(Collectors.toSet());
        employees.stream().forEach(e -> {
            FinalStockPrice finalStockPrice = stringFinalStockPriceMap.get(e.getInstrument());
            if (finalStockPrice == null) {
                finalStockPrice = new FinalStockPrice();
                finalStockPrice.setSymbol(e.getInstrument());
                if (e.getTransactiontype().equalsIgnoreCase("BUY")) {
                    finalStockPrice.setBuyPrice(e.getAmount());
                    finalStockPrice.setTotal(e.getAmount());
                }
                if (e.getTransactiontype().equalsIgnoreCase("SELL")) {
                    finalStockPrice.setSellPrice(e.getAmount());
                    finalStockPrice.setTotal(e.getAmount());
                }
                if (e.getTransactiontype().equalsIgnoreCase("CDIV")) {
                    finalStockPrice.setTotal(e.getAmount());
                }
                if(e.getDescription().equalsIgnoreCase("Deposit")){
                    finalStockPrice.setSymbol(e.getDescription());
                    float total = finalStockPrice.getTotal();
                    finalStockPrice.setTotal(total+e.getAmount());
                }


                stringFinalStockPriceMap.put(e.getInstrument(), finalStockPrice);
            } else {
                if (e.getTransactiontype().equalsIgnoreCase("BUY")) {
                    float buy = finalStockPrice.getBuyPrice();
                    finalStockPrice.setBuyPrice(buy + e.getAmount());
                    float total = finalStockPrice.getTotal();
                    finalStockPrice.setTotal(total + e.getAmount());
                }
                if (e.getTransactiontype().equalsIgnoreCase("SELL")) {
                    float sell = finalStockPrice.getSellPrice();
                    finalStockPrice.setSellPrice(sell + e.getAmount());
                    float total = finalStockPrice.getTotal();
                    finalStockPrice.setTotal(total + e.getAmount());
                }
                if (e.getTransactiontype().equalsIgnoreCase("CDIV")) {
                    float total = finalStockPrice.getTotal();
                    finalStockPrice.setTotal(total+e.getAmount());
                }
                if(e.getDescription().equalsIgnoreCase("Deposit")){
                    float total = finalStockPrice.getTotal();
                    finalStockPrice.setTotal(total+e.getAmount());
                }
            }
        });
        System.out.println(stringFinalStockPriceMap.values());
    }
}
