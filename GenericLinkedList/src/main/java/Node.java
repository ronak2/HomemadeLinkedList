
//This class represents a node structure to be used as items on the generic linked list
public class Node<T>
{
	//Private members of the generic Node class
	private T data; //Variable storing the current value of the node
	private Node<T> next; //Node to store the node before the current node on the list
	private Node<T> prev; //Node to store the node after the current node on the list
		
	//Node constructor
	public Node(T val)
	{
		data = val; //Initializing the current node's data field with the given value
		next = null;
		prev = null;
	}
		
	/*
	* The following methods are getters/setters for the Node class private members
	*/
		
	//Getter method for the next node
	public Node<T> getNext()
	{
		return next;
	}
	//Setter method for the next node
	public void setNext(Node<T> newNext)
	{
		next = newNext;
	}
		
	//Getter method for the previous node
	public Node<T> getPrev()
	{
		return prev;
	}
	//Setter method for the previous node
	public void setPrev(Node<T> newPrev)
	{
		prev = newPrev;
	}
		
	//Getter method for the node's data field
	public T getData()
	{
		return data;
	}
	//Setter method for the node's data field
	public void setData(T val)
	{
		data = val;
	}
}
