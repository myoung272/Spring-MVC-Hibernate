
package f2os.net.springcrud.util;


import java.util.HashMap;
import java.util.Map;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;
public class SendNotifications {
/* Twilio REST API version */
public static final String ACCOUNTSID = "AC5a70cd3798a5417b8a52c5ef57ea0b03";
public static final String AUTHTOKEN = "0b51562c610261367eca0ba9e25448c3";
public static void sendSms(String body, String smsNum){
/* Instantiate a new Twilio Rest Client */
TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN);
// Get the account and call factory class
Account acct = client.getAccount();
SmsFactory smsFactory = acct.getSmsFactory();
//build map of server admins
Map<String,String> admins = new HashMap<String,String>();
admins.put(smsNum, "Order Taker:");
//admins.put("7328325577", "Timmy");
// admins.put("7323371194", "Ted");
// 415-599-2671
String fromNumber = "732-784-6062";
// Iterate over all our server admins
for (String toNumber : admins.keySet()) {
//build map of post parameters 
Map<String,String> params = new HashMap<String,String>();
params.put("From", fromNumber);
params.put("To", toNumber);
params.put("Body", "ORDER ALERT! " + admins.get(toNumber) + "," +body+ "");
try {
// send an sms a call 
// ( This makes a POST request to the SMS/Messages resource)
Sms sms = smsFactory.create(params);
System.out.println("Success sending SMS: " + sms.getSid());
}
catch (TwilioRestException e) {
e.printStackTrace();
}
}
} 
}
