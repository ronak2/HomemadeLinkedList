import java.util.Iterator;
public class GLLIterator<T> implements Iterator<T> 
{
	Node<T> currentNode; //Declaring a node to represent the current item on the list
	
	//Initializing the current node to be the first node on the list
	public GLLIterator(GenericLinkedList<T> linkedList)
	{
		currentNode = linkedList.getHead();
	}
	
	//Defining the inherited method indicating if more nodes remain on the list after current
	public boolean hasNext()
	{
		return (currentNode != null); //Return true if a next node exists
	}
	
	//Defining the inherited method that returns the current node on the list and moves to the next node
	public T next()
	{
		T currentValue = currentNode.getData();
		currentNode = currentNode.getNext();
		return currentValue;
	}
	
}
