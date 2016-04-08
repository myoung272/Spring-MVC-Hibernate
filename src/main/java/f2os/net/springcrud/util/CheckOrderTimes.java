 
package f2os.net.springcrud.util;

import f2os.net.springcrud.model.OrderHours;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CheckOrderTimes {
 OrderHours ohb;

	public static boolean checkOrderTimes(OrderHours ohb) {
	  Calendar calendar = new GregorianCalendar();
	   int hour = calendar.get(Calendar.HOUR_OF_DAY);
	   int minute = calendar.get(Calendar.MINUTE);
	   int day = calendar.get(Calendar.DAY_OF_WEEK);
	   int msHour = hour * 3600000;
	   int msMin = minute * 6000;
	   int msTime = msHour + msMin; // time of day
	   Time  s = null;
	   Time  f = null;
	 
	  
	   
	   switch(day){
	   case 1:
		     s = ohb.getSu();
		    f = ohb.getFsu();
		  break;
	   case 2:
		     s = ohb.getMo();
		    f = ohb.getFmo();
		  break; 
		   case 3:
			  s = ohb.getTu();
		  f = ohb.getFtu();
			   break;
		   case 4:
			  s = ohb.getWe();
			     f = ohb.getFwe();
			   break;
		   case 5:
			     s = ohb.getTr();
			     f = ohb.getFtr();
			   break;
		   case 6:
	           s = ohb.getFr();
			   f = ohb.getFfr();
			   break;
		   case 7:
			  s = ohb.getSa();
			  f = ohb.getFsa();
			   break;
	   }
	   
	  
	   int sTimeHour = s.getHours() * 3600000;
	   int sTimeMin = s.getMinutes() *  6000;
	   int sTime = sTimeHour + sTimeMin;
	   int fTimeHour = f.getHours() * 3600000;
	   int fTimeMin = f.getMinutes() *  6000;
	   int fTime = fTimeHour + fTimeMin;
	   
	   if(msTime >= sTime &&  msTime <= fTime ){
		 return true;
	   }
	   else 
		return false;   
	  

}
}
