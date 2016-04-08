 
package f2os.net.springcrud.container;

/**
 *
 * @author Mitch
 */


public class OrderTotals {
    
   private double subTotal;
   private double salesTax;
   private double total;
   private int deliveryCharge;
   
   public OrderTotals(){}

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the salesTax
     */
    public double getSalesTax() {
        return salesTax;
    }

    /**
     * @param salesTax the salesTax to set
     */
    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the deliveryCharge
     */
    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    /**
     * @param deliveryCharge the deliveryCharge to set
     */
    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }
           
    
    
}
