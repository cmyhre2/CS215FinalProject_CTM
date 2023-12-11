/**
 * This class creates and manages the gates at the station in the subway simulation.
 * 
 * @author Chris Myhre
 * @version 1.0 (12/11/2023)
 * Fall 2023 (CS-215 Class Project)
 */
public class Gate {
	private Train train = null;//Train variable to track what train has stopped at a gate.
	private boolean isClear = true;//boolean variable to trakc if a gate is clear for a train to stop at.
	private String action = "Available";//String Variable to describe what a train is doing while at a gate.
	private int stage = 0;//stage variable to progress a train's action to the next one while at a gate. Then eventually the train leaves and clears the gate.
	
	/**
	 * This method assigns a train to an empty gate.
	 */
	public void assignGate(Train t) {
		setTrain(t);
		progressStage();
	}//end assignGate()
	
	/**
	 * This method updates all gates info based on what stage they just progressed to.
	 */
	public void progressStage() {
		setStage(getStage()+1);
		switch (stage%5) {
		case 0: clearGate(); setAction("Available"); break;
		case 1: setAction("Train Number " + getTrain().getTrainNumber() + " is letting off passengers."); setIsClear(false); break;
		case 2: setAction("Train Number " + getTrain().getTrainNumber() + " is getting ready for the next trip."); break;
		case 3: setAction("Train Number " + getTrain().getTrainNumber() + " is letting passengers on."); break;
		case 4: setAction("Train Number " + getTrain().getTrainNumber() + " is taking off.");
		}//end switch statement
	}//end progressStage()
	
	/**
	 * This method marks a gate as "available" and resets all instance variables to starting values.
	 */
	public void clearGate() {
		setTrain(null);
		setIsClear(true);
		setAction("Available");
		setStage(0);
	}//end clearGate()
	
	/**
	 * This method sets a gate's action.
	 * @param a
	 */
	public void setAction(String s) {
		action = s;
	}//end setAction;
	
	/**
	 * This method gets a gate's action.
	 * @return action
	 */
	public String getAction() {
		return action;
	}//end getAction()
	
	/**
	 * This method sets a gate's stage.
	 * @param s
	 */
	public void setStage(int s) {
		stage = s;
	}//setStage()
	
	/**
	 * This method returns a gate's stage.
	 * @return stage
	 */
	public int getStage() {
		return stage;
	}//end getStage()
	
	/**
	 * This method sets the train that comes to a gate.
	 * @param t
	 */
	public void setTrain(Train t) {
		train = t;
	}//end setTrain()
	
	/**
	 * This method returns the train currently at a gate.
	 * @return train
	 */
	public Train getTrain() {
		return train;
	}//end getTrain()
	
	/**
	 * This method sets the status of a gate.
	 * @param s
	 */
	public void setIsClear(boolean s) {
		isClear = s;
	}//end setIsClear()
	
	/**
	 * This method returns that status of a gate.
	 * @return isClear
	 */
	public boolean getIsClear() {
		return isClear;
	}//end getIsClear()
}//end Gate class