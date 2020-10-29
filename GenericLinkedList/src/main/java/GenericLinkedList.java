import java.util.Iterator;
import java.util.ListIterator;
import java.lang.Iterable;
//This class represents a generic linked list structure
public class GenericLinkedList<T> implements Iterable<T>{
	
	//Private members of the generic linked list
	private Node<T> head; //The head node represents the first node on the linked list
	private Node<T> tail; //The tail node represents the last node on the linked list
	private int length; //The length variable returns how many nodes are currently on the list
	
	//Implementing the abstract method iterator from Iterable
	public Iterator<T> iterator()
	{
		return new GLLIterator<T>(this);
	}
	
	//Linked list constructor
	public GenericLinkedList(T val)
	{
		head = new Node<T>(val); //Initializing the head node's data field with the given value
		head.setNext(null);
		head.setPrev(null);
		tail = head;
		length = 1; 
	}
	
	//Inserts the specified element at the beginning of the list
	public void addFirst(T e)
	{
		Node<T> newNode = new Node<>(e); //Initializing a new node with the specified value
		length++; //Increasing the length of the list to account for the new node
		if (head == null)
		{
			//Executes if the list is empty
			head = newNode;
			tail = head;
		}
		else
		{
			head.setPrev(newNode);
			Node<T> tempNode = head;
			head = newNode;
			head.setNext(tempNode);
		}
	}
	
	//Inserts the specified element at the end of the list
	public void addLast(T e)
	{
		Node<T> newNode = new Node<>(e); //Initializing a new node with the specified value
		length++; //Increasing the length of the list to account for the new node
		if (head == null)
		{
			//Executes if the list is empty
			head = newNode;
			tail = head;
		}
		else
		{
			tail.setNext(newNode);
			Node<T> tempNode = tail;
			tail = newNode;
			tail.setPrev(tempNode);
		}
	}
	
	//Returns the number of elements in the list
	public int size()
	{
		return length;
	}
	
	//Returns true if the list contains the specified element
	public boolean contains(T e) 
	{
		Node<T> current = head; //Setting the iterating node to start at the head
		
		while(current!=null)
		{
			if(current.getData()==e)
			{
				return true; //Returns true when element is found
			}
			else
			{
				current = current.getNext(); //Traversing to the next node on the list
			}
		}
		return false; //Returns false when the element is not in the list
	}
	
	//Removes the first occurrence of the specified element 
	//	and returns true or returns false if the element does not exist.
	public boolean remove(T e)
	{
		if (head == null)
	    {
	    	return false; //Executes if the list is empty
	    }
		if ((head.getData()) == e)
	    {
	       head = head.getNext(); //Updating the head pointer if the list has one element
	       length--;
	       return true;
	    }
		Node<T> current = head; //Setting the iterating node to start at the head
		while(current != null && current.getData() != e)
		{
			current = current.getNext();
		}
		if (current == null)
			return false;
		if(current.getPrev() != null)
			current.getPrev().setNext(current.getNext());
		if(current.getNext() != null)
			current.getNext().setPrev(current.getPrev());
		length--;
		return true;
	}
	
	//Removes all elements from the list
	public void clear()
	{
		head = null;
		tail = null;
	}
	
	//Returns the element at the specified index or null if the index is out of bounds.
	public T get(int index) 
	{
		if( (index > (length - 1)) || (index < 0))
		{
			return null;
		}
		else if (index == 0) //If the head element is desired
		{	T oldElement = head.getData();
			return oldElement;
		}
		else
		{
			Node<T> current = head;
			int count = 0;
			while(count != index)
			{
				current = current.getNext();
				count++;
			}
			return (current.getData());
		}
	}
	
	//Replaces the element at specified position in the list with the specified element 
	//	and returns the element previously at the specified position. 
	//Returns null if index is out of bounds
	public T set(int index, T element) 
	{
		if( (index > (length - 1)) || (index < 0))
		{
			return null;
		}
		else if (index == 0) //If the head element is desired
		{	T oldElement = head.getData();
			head.setData(element);
			return oldElement;
		}
		else
		{
			Node<T> current = head;
			int count = 0;
			while(count != index)
			{
				current = current.getNext();
				count++;
			}
			T oldElement = current.getData();
			current.getPrev().getNext().setData(element);
			return oldElement;
		}
	}
	
	//Retrieves and removes the head of the list
	public T removeHead()
	{
		if(head == null) //Empty case
			return null;
		else if(head.getNext()==null) //Singleton case
		{
			T headVal = head.getData();
			head = null;
			tail = head;
			return headVal;
		}
		else
		{
			T headVal = head.getData();
			head.getNext().setPrev(null);
			head = head.getNext();
			return headVal;
		}
		
	}
	
	//Retrieves and removes the tail of the list
	public T removeTail()
	{
		if(head == null) //Empty case
			return null;
		else if(head.getNext()==null) //Singleton case (head and tail are the same)
		{
			T tailVal = head.getData();
			head = null;
			tail = head;
			return tailVal;
		}
		else
		{
			T tailVal = tail.getData();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
			return tailVal;
		}
	}
	
	//Returns a list-iterator of the elements of this list starting at the specified position.
	public ListIterator<T> listIterator(int index)
	{
		if( (index > (length - 1)) || (index < 0))
		{
			return null;
		}
		return new GLLListIterator<T>(index, this);
	}
	
	//Returns an iterator over the elements of the list in reverse order (tail to head).
	public Iterator<T> descendingIterator()
	{
		return new ReverseGLLIterator<T>(this);
	}
	
	
	
	
	
	/*
	* The following methods are getters/setters for the GenericLinkedList class private members
	*/
	
	//Getter method for the head node
	public Node<T> getHead()
	{
		return head;
	}		
	
	//Setter method for the head node
	public void setHead(Node<T> newHead)
	{
		head = newHead;
	}
	
	//Getter method for the head node
	public Node<T> getTail()
	{
		return tail;
	}
				
	//Setter method for the head node
	public void setTail(Node<T> newTail)
	{
		head = newTail;
	}
	
	//Getter method for the length of the list
	public int getLength()
	{
		return length;
	}
					
	//Setter methods to increase/decrease the length by 1
	public void incrementLength()
	{
		length++;
	}
	public void decrementLength()
	{
		length--;
	}

}
