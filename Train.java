/**
 * This class creates and manages Trains that will ultilize the small Train Station in the subway train station simulation.
 * 
 * @author Chris Myhre
 * @version 3.0 (12/11/2023)
 * Fall 2023 (CS-215 Class Project)
 */
public class Train {
	private int trainNumber;//int variable to store the train's numeric ID.
	private Train nextTrain;//Train variable to track the next train.
	private double startingDistanceFromStation;//double variable to store a train's starting distance from the station.
	private double distanceFromStation;//double variable to store the time until a train arrives.
	private double speed;//double variable to track a train's speed.
	/**
	 * preferred constructor to creating a Train type object
	 * @param id, d, rd
	 */
	public Train(int i) {
		setStartingDistanceFromStation(300.0);
		setDistanceFromStation(getStartingDistanceFromStation());
		setSpeed(75.0);
		setTrainNumber(i);
	}//end Train()
	
	/**
	 * This method updates a train's speed based on the percentage of it's route distance to the station completed.
	 * routeCompletion 1 = 10% of route completed
	 * routeCompletion 2 = 20% of route completed, etc.
	 */
	public void updateSpeed() {
		int routeCompletion = (int)(10*(1.0 - (getDistanceFromStation()/getStartingDistanceFromStation())));
		switch(routeCompletion){
		case 10: setSpeed(0.0); break;//100% Route completion = Speed 0 mph
		case 9: setSpeed(15.0); break;//90% Route completion = Speed 15 mph
		case 8: setSpeed(25.0); break;//80% Route completion = Speed 25 mph
		case 7: setSpeed(50.0); break;//70% Route completion = Speed 50 mph
		default: setSpeed(75.0);//<70% Route completion = Full Speed 75 mph
		}//end switch statement
	}//end updateSpeed()
	
	/**
	 * @return the startingDistanceFromStation
	 */
	public double getStartingDistanceFromStation(){
		return startingDistanceFromStation;
	}//end getStartingDistanceFromStation()
	
	/**
	 * @param sd
	 */
	public void setStartingDistanceFromStation(double sd){
		startingDistanceFromStation = sd;
	}//end setStartingDistanceFromStation()
	
	/**
	 * This method sets the speed of a train.
	 * @param s
	 */
	public void setSpeed(double s) {
		speed = s;
	}//end setSpeed()
	
	/**
	 * This method returns the speed of a train.
	 * @return s
	 */
	public double getSpeed() {
		return speed;
	}//end getSpeed()
	
	/**
	 * This method sets the distance a train is from the station.
	 * @param time
	 */
	public void setDistanceFromStation(double d) {
		distanceFromStation = d;
	}//end setDistanceFromStation()
	
	/**
	 * This method returns the distance a train is from the station.
	 * @return time
	 */
	public double getDistanceFromStation() {
		return distanceFromStation;
	}//end getDistanceFromStation()
	
	/**
	 * This method updates the pointer for the next type T node.
	 * @param nextNode
	 */
	public void setNextTrain(Train nextTrain) {
		this.nextTrain=nextTrain;
	}//end setNextTrain
	
	/**
	 * This method returns the train stored in the next train pointer.
	 * @return Train object
	 */
	public Train getNextTrain() {
		return nextTrain;
	}//end getNextTrain()
	
	/**
	 * @return the trainNumber
	 */
	public int getTrainNumber() {
		return trainNumber;
	}//end gettrainNumber()
	
	/**
	 * @param i
	 */
	public void setTrainNumber(int i) {
		trainNumber = i;
	}//end settrainNumber()
}//end Train class