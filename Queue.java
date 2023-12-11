/**
 * This class tracks to order in which nodes are processed with the help of the LinkedList class.
 * 
 * @author Chris Myhre
 * @version 2.0 (12/11/2023)
 * Fall 2023 (CS-215 Class Project)
 */
public class Queue<T> {
	private LinkedList list = new LinkedList();//LinkedList variable list to store a list of Strings (Customer names)

	/**
	 * Method to see if there are any elements in the linked list.
	 * @return boolean true/false
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}//end isEmpty
	
	/**
	 * This method prints the queue. First, checks if the queue is empty and prints an appropriate response 
	 * for that situation. Otherwise, cycles through the linked list and prints the data of each node.
	 * @return method terminates if the queue is empty
	 */
	public void getQueue()
	{
		if(list.isEmpty()) {
			System.out.println("No trains are approaching the subway station.");
			return;
		}
		System.out.print("\nTrains approaching the subway station: ");
		Train node = list.getList();
		while(node!=null) {
			System.out.print("\nTrain #" + node.getTrainNumber());
			System.out.print(" | Distance from Station: " + node.getDistanceFromStation() + " miles");
			System.out.print(" | Speed: " + node.getSpeed() + " mph");
		node = node.getNextTrain();
		}//while loop
		System.out.println("\n");
	}//end getQueue
	
	private Train temp = null;//temp variable to pass the dequeued train to the Station class
	/**
	 * This method returns the dequeued Train variable so the Station class can access the dequeued train object;
	 * @return temp
	 */
	public Train getTemp() {
		return temp;
	}//end getTemp()
	
	/**
	 * This method sets the temp variables
	 * @param t
	 */
	public void setTemp(Train t) {
		temp = t;
	}//end setTemp()
	
	/**
	 * This method updates all trains' info. Updates the temp Train variable to null if no trains are dequeued from this method,
	 * otherwise sets the temp Train variable to the dequeued Train object.
	 */
	public void updateTrains(){
		if(!list.isEmpty()) {
			Train node = list.getList();
			while(node!=null) {
				node.setDistanceFromStation(node.getDistanceFromStation()-(node.getSpeed()/2.0));
				if(node.getDistanceFromStation()<=0) {
					node.setSpeed(0.0);
					node.setDistanceFromStation(0.0);
					temp = dequeue();
					System.out.println("\nTrain " + temp.getTrainNumber() + " has arrived!");
				}//end inner if statement
				else {node.updateSpeed();}//end else statement
				node = node.getNextTrain();
			}//while loop
		}//end outer if statement
		else temp = null;//if no train is dequeued, temp is set to null to prevent sending duplicate trains to the other gates.
	}//end updateTrains()
	
	/**
	 * This method adds a new type T node to the queue. It first checks to see
	 * if the queue is empty. If so, it sets the head and the tail nodes
	 * to the node passed in. If the queue is not empty it places the node
	 * at the end of the list and updates the pointers in the tail. This
	 * implementation does not support adding entries to the middle
	 * of the queue.
	 * @param aNode
	 */
	public void enqueue(Train aNode)
	{
		list.addNode(aNode);
	}//end enqueue()
	
	/**
	 * This method removes the first node in the queue and returns it.
	 * @return list.removeHead()
	 */
	public Train dequeue()
	{
		if (list.isEmpty() ) {
			System.out.println("Error: There are no trains approaching the station.");
		}//end if statement
		return list.removeHead();
	}//end dequeue()
}//end Queue class