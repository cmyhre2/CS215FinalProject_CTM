/**
 * This class runs the simulation of a small Subway Train Station. This class is responsible for manging the timings of
 * when a train is approaching the station and when it leaves. This class is the face of the program and will refresh the
 * screen after every time interval.
 * 
 * @author Chris Myhre
 * @version 2.0 (12/11/2023)
 * Fall 2023 (CS-215 Class Project)
 */
import java.util.Timer;
public class Application {
	/**
	 * The main method runs the subway simulation.
	 * @param args
	 */
	public static void main(String[]args) {
		Timer timer = new Timer();
		Timekeeper time = new Timekeeper();
		timer.schedule(time, 0, 2000);
	}//end main()
}//end Application class
