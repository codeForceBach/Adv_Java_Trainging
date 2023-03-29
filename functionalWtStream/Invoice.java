package functionalWtStream;

import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {

    private String invoiceNo;
    private BigDecimal unitPrice;
    private Integer qty;

    public Invoice() {
    }

    public Invoice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Invoice(String invoiceNo, BigDecimal unitPrice, Integer qty) {
        this.invoiceNo = invoiceNo;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNo='" + invoiceNo + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceNo().equals(invoice.getInvoiceNo()) && getUnitPrice().equals(invoice.getUnitPrice()) && Objects.equals(getQty(), invoice.getQty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceNo(), getUnitPrice(), getQty());
    }
}//end class
