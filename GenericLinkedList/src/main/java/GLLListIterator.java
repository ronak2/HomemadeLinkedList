import java.util.ListIterator;
public class GLLListIterator<T> implements ListIterator<T>
{
	private int currentIndex;
	private Node<T> currentNode;
	GenericLinkedList<T> linkedList; //Declaring a node to represent the current item on the list
	
	
	public GLLListIterator(int index, GenericLinkedList<T> genericLinkedList)
	{
		currentIndex = index;
		linkedList = genericLinkedList;
		Node<T> current = linkedList.getHead();
		int count = 0;
		while(count != currentIndex)
		{
			current = current.getNext();
			count++;
		}
		currentNode = current;
	}

	public boolean hasNext() 
	{
		return (currentNode != null); //Return true if a next node exists
	}

	public T next() 
	{
		T currentValue = currentNode.getData();
		currentNode = currentNode.getNext();
		currentIndex++;
		return currentValue;
	}

	public boolean hasPrevious() 
	{
		return (currentNode != null); //Return true if a next node exists
	}

	public T previous() {
		T currentValue = currentNode.getData();
		currentNode = currentNode.getPrev();
		currentIndex--;
		return currentValue;
	}

	public int nextIndex() {
		return currentIndex;
	}

	@Override
	public int previousIndex() {
		return currentIndex;
	}

	@Override
	public void remove() {
		// throw new UnsupportedOperationException();
		
	}

	@Override
	public void set(T e) {
		// throw new UnsupportedOperationException();
		
	}

	@Override
	public void add(T e) {
		// throw new UnsupportedOperationException();
		
	}
	
}
