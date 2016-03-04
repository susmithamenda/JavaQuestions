import java.util.Timer;
import java.util.TimerTask;


public class BackgroundTimer extends TimerTask{

	public void run()
	{
		System.out.println("Hello there!");
	}
	
	public static void main(String[] args)
	{
		Timer tm = new Timer();
		tm.schedule(new BackgroundTimer(), 0, 5000);
	}
}
