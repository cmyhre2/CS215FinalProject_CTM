/**
 * This class creates and manages the timings of the subway simulation.
 * 
 * @author Chris Myhre
 * @version 2.0 (12/11/2023)
 * Fall 2023 (CS-215 Class Project)
 */
import java.io.IOException;
import java.util.TimerTask;
public class Timekeeper extends TimerTask{
	public static int timestep = -1;// timestep variable, starts at -1 so the first simulation tick is 0 (0:00:00)
	Station subway = new Station();
	
	/*
	 * This method is inherited from the abstract class TimerTask. This method body will
	 * trigger once, kick starting the simulation. Once the time variable reaches its max
	 * value, the simulation will terminate.
	 */
	public void run() {
		clear();
		System.out.println("\n======================================================================================");
		timestep++;//timestep +1
		String str = String.format("%02d", (timestep*30)%60);//formats minutes to have a leading zero.
		System.out.println("Timestep: " + timestep + " (" + timestep/2 + ":" + str + ":00)");
		subway.updateTrains();//updates train info
		subway.updateGates();//updates gate info
		System.out.println(subway.getGates());//prints gate info
		subway.trainEvent();//25% chance to create a new train
		subway.viewApproachingTrains();//view station queue of incoming trains
		if(timestep>=25) {
			System.exit(0);
		}//end if statement
	}//end run()
	
	
	/**
	 * This method clears the screen
	 */
	public static void clear(){
        try{
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }catch (IOException | InterruptedException ex) {}
    }//end clear()
}//end TimeKeeper class