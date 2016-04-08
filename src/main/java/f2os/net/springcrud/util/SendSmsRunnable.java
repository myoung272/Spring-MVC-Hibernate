
package f2os.net.springcrud.util;


public class SendSmsRunnable extends SendNotifications implements Runnable {
	String smsNum;
	String body;
public	SendSmsRunnable(String body, String smsNum){
		this.body = body;
		this.smsNum = smsNum;
		}
	@Override
	public  synchronized  void run() {
		sendSms(this.body, this.smsNum);
		System.out.println("Inside SendSmsRunnable this thread is: "+ 
		Thread.currentThread().getName()+ "  the tread's state Is: " +Thread.currentThread().getState());

	}

}

