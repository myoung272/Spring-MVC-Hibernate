 
package f2os.net.springcrud.util;


import f2os.net.springcrud.container.OrderTotals;
import f2os.net.springcrud.model.Customers;

import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.model.Orders;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendGmailRunnable implements Runnable{
    private List<Menu> orderHolder;
    private Customers uBean;
    private OrderTotals ots;
    private Orders order;
    private String comments = "need to get from form";
    
    
    
    public SendGmailRunnable(List<Menu> orderList, Customers user, OrderTotals ots, Orders order ){
        this.orderHolder = orderList;
        this.uBean = user;
        this.order = order;
        this.ots = ots;
                
    }
    
    public void run(){
        
      
        int intPickDel = 2;
        double t =0;
	   	 double st =0;
	   	 double dc = 1; // set this with a properties file
	   	 double sub =0;
	   	 for(Menu ob : orderHolder ){
	   		  t = t + ob.getPrice().doubleValue()* ob.getQuantity();
	   		  }
	   	 sub = t;
	   	if(intPickDel == 2){
	   		t = t + dc;
	   	}
	   	 st = t * .07; // sales tax rate, need to set this through an admin function
	   	 t = t + st;
    
        
         String to = uBean.getEmail();
	        String cc = "myphoto@msn.com";
	        String from = "supermariopizza@msn.com";
	        String subject = "Order Confirmation from Super Mario Pizza";
	       StringBuilder sb = new StringBuilder();
	        String bbody = "<p>Your Order Details from Super Mario Pizza </p>" +
	           "<html><body> <p> Name: " + uBean.getFname() + " "+uBean.getLname()+" Phone: "+uBean.getPhone()+"<br /> "+
	        		"Address: " +uBean.getStreet()+ ", " +uBean.getCity()+ "<br />" +
	        	 "Customer Number " +uBean.getCustId()+ " Order Number " +order.getOrderId()+ "<br />"	+
	              "Thank You for your Order<br />" +
	            "Your order contains: </p>" ;
	        sb.append(bbody);
                String table ="<table rules=\"rows\" style=\"margin: auto; padding: 5px;\"><tr bgcolor=\"#E2D1B8\"><td >Category</td><td>Item</td><td>Description</td><td>Size</td><td>Quantity</td><td>Price</td><td>Amount</td></tr>";
                sb.append(table);
	        DecimalFormat df = new DecimalFormat("#.00");
	        String sd = "";
	             for(int i = 0; i < orderHolder.size(); i++){
	            	 String cat = orderHolder.get(i).getCategory();
	            	 sb.append("<tr><td>"+cat +"</td> " );
	            	 String item = orderHolder.get(i).getItem();
	            	 sb.append("<td>"+item + "</td> ");
	            	 String desc = orderHolder.get(i).getDescription();
	            	 sb.append("<td>"+desc +"</td>");
	            	 String size = orderHolder.get(i).getSize();
	            	 sb.append("<td>"+size + "</td>");
	            	 String quant = Integer.toString(orderHolder.get(i).getQuantity());
	            	 sb.append("<td>"+quant + "</td> ");
	            	 String price =  df.format(orderHolder.get(i).getPrice());
	            	 sb.append("<td>$" +price+ "</td> ");
                         double itemTotal = orderHolder.get(i).getPrice().doubleValue() * orderHolder.get(i).getQuantity();
	            	 String amount = df.format(itemTotal);
	            	 sb.append("<td>$"+amount+ "</td></tr>");
	            	 } //close for
                         sb.append(" <tr><td>&nbsp;</td></tr></table>");
	                 sd = df.format(sub);
	                 sb.append("Sub Total: $" + sd+ "<br />" );
	             	 if(intPickDel == 2){
	             	 sd = df.format(dc);	 
	                 sb.append("Delivery Charge: $" +sd+ "<br />" );
	             	 }
	             	 sd = df.format(st);
	             	 sb.append("Sales Tax: $" +sd+ "<br />" );
	                 sd = df.format(t);
	                 sb.append("Order Total: $" +sd+ "<br />");
	                 sb.append("Special Instructions: " +comments+ "<br />");
	             //    sb.append("This Order Is For: " +delStat+ "\n");
	                 sb.append("Please review your order and call right away if there is a problem <br />Thank You\nSuper Mario's Pizza </body></html>");
	                 String body = sb.toString();
	                // boolean isBodyHTML = false;
	                 // admin can turn off sms and fax notifications
                          ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
                          
                           HTMLMail mm = (HTMLMail) context.getBean("htmlMail");
        
            mm.sendMail("supermariopizza@msn.com",
            uBean.getEmail(),
            "Your Order from Super Mario Pizza",
            body);
            
    }
    
}
