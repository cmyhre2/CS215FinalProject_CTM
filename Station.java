/**
 * This class creates and manages the station part of the subway simulation.
 * 
 * @author Chris Myhre
 * @version 3.0 (12/11/2023)
 * Fall 2023 (CS-215 Class Project)
 */
public class Station {
	private Queue<Train> stationQueue = new Queue<Train>();//Queue for trains
	private Gate gate1 = new Gate();//Gate for a train to stop at the station
	private Gate gate2 = new Gate();//Gate for a train to stop at the station
	private Gate gate3 = new Gate();//Gate for a train to stop at the station
	private int trainsGenerated = 0;//int for tracking number of trains generated and for making train numbers unique
	
	/**
	 * This method updates all info on Gates.
	 */
	public void updateGates() {
		if(!gate1.getIsClear())
			gate1.progressStage();
		if(!gate2.getIsClear())
			gate2.progressStage();
		if(!gate3.getIsClear())
			gate3.progressStage();
	}//end updateGates()
	
	/**
	 * This method creates a train with a unique id that's 300 miles from the station.
	 */
	public void trainEvent() {
		int randomNumber = (int)(4*Math.random()+1);
		if(randomNumber >= 4) {
			trainsGenerated++;
			Train train = new Train(trainsGenerated);
			stationQueue.enqueue(train);
		}//end if statement
	}//end trainEvent()
	
	/**
	 * This method returns a sb.toString() String for the Timekeeper class to display the gates' statuses.
	 * @return str
	 */
	public String getGates() {
		StringBuilder sb = new StringBuilder("\nGate 1 Status: " + gate1.getAction());
		sb.append("\nGate 2 Status: " + gate2.getAction());
		sb.append("\nGate 3 Status: " + gate3.getAction());
		String str = sb.toString();
		return str;
	}//end getGates()
	
	/*
	 * This method allows the Timekeeper class to view the queue
	 */
	public void viewApproachingTrains() {
		stationQueue.getQueue();
	}//end viewApproachingTrains()
	
	/**
	 * This method updates train info. If a train is dequeued, it goes to an empty gate.
	 * When a gate is assigned a train, the temp variable in the Queue class is set to
	 * null to avoid duplicate trains from taking the other gates.
	 */
	public void updateTrains() {
		stationQueue.updateTrains();
		Train train = stationQueue.getTemp();
		if(train!=null) {
			if(gate1.getIsClear()) {
				gate1.assignGate(train); stationQueue.setTemp(null); return;
			} else if(gate2.getIsClear()){
				gate2.assignGate(train); stationQueue.setTemp(null); return;
			} else if(gate3.getIsClear()){
				gate3.assignGate(train); stationQueue.setTemp(null); return;
			}//end inner if statements
		}//end outer if statement
	}//end updateTrains()
}//end Station class