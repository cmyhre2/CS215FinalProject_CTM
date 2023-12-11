/**
 * This class models a linked list in which each node has a pointer
 * to the node after it, except the tail which does not have a node after.
 * @author rkelley/njohnson (v1.0) & Chris Myhre (v1.1+)
 * @version 1.3 (11/30/2023)
 * Fall 2023 (CS-215 Class Project)
 */
public class LinkedList {

	private Train head; //Type T node to represent the head of the list
	private Train tail; //Type T node to represent the tail (end) of the list
	private int length; //variable to keep track of the number of elements in the list
	
	/**
	 * The constructor for this object initializes the list such that
	 * it is empty (no head or tail) node.
	 */
	public LinkedList() {
		head=null;
		length=0;
		tail=head;
	}//end empty-argument constructor
	
	/**
	 * Method to see if there are any elements in the list.
	 * @return boolean true/false
	 */
	public boolean isEmpty() {
		if (head==null) { return true;}
		else return false;
	}//end isEmpty
	
	/**
	 * This method returns the head node of the list from which
	 * you can traverse the entire by following node links.
	 * @return
	 */
	public Train getList() {
		return head;
	}//end getList
	
	/**
	 * This method returns the length of the linked list.
	 * @return length
	 */
	public int getLength() {
		return length;
	}//end getLength()
	
	/**
	 * This method adds a new type T node to the list. It first checks to see
	 * if the list is empty. If so, it sets the head and the tail nodes
	 * to the node passed in. If the list is not empty it places the node
	 * at the end of the list and updates the pointers in the tail. This
	 * implementation does not support adding entries to the middle
	 * of the list.
	 * @param aNode
	 */
	public void addNode(Train t) {
		if (isEmpty() ) {
			head = t;
			tail=head;
			return;
		}
		
		tail.setNextTrain(t);
		tail=tail.getNextTrain();
		tail.setNextTrain(null);
		length++;
		
	}//end addNode
	
	/*
	 * This method removes the head of the linked list.
	 */
	public Train removeHead() {
		if (isEmpty() ) {
			System.out.println("Error");
			return null;
		}
		Train temp = head;
		head = head.getNextTrain();
		length--;
		return temp;
	}//end removeHead()
}//end LinkedList class