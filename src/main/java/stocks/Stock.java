package stocks;

import io.github.millij.poi.ss.model.annotations.SheetColumn;

public class Stock {
    @SheetColumn("Activity Date")
    String activityDate;
    @SheetColumn("Process Date")
    String processDate;
    @SheetColumn("Settle Date")
    String settleDate;
    @SheetColumn("Instrument")
    String instrument;
    @SheetColumn("Description")
    String description;
    @SheetColumn("Trans Code")
    String transactiontype;
    @SheetColumn("Quantity")
    String quantity;
    @SheetColumn("Price")
    float price;
    @SheetColumn("Amount")
    float amount;

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
