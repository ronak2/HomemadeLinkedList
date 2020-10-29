import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class GenericLinkedListTest 
{
	
	static GenericLinkedList<Integer> gll; //Declaring the first test list
	static GenericLinkedList<Integer> gll2; //Declaring the second test list
	@BeforeAll
	static void setUp() //Initializing the test list
	{
		gll = new GenericLinkedList<>(2);
		gll2 = new GenericLinkedList<>(4);
	}
	
	@Test
	void GLLConstructor_test1() //Testing if the head node has been initialized
	{
		assertEquals(4,gll2.getHead().getData(),"Wrong Value!");
	}
	
	@Test
	void GLLConstructor_test2() //Testing if the head node has been initialized
	{
		assertEquals(1,gll2.getLength(),"Wrong size value!");
	}
	
	@Test
	void NodeConstructor_test1() //Testing if the head's next node has been initialized to null
	{
		assertEquals(null,gll2.getHead().getNext(),"Null value expected!");
	}
	
	@Test
	void NodeConstructor_test2() //Testing if the head's previous node has been initialized to null
	{
		assertEquals(null,gll2.getHead().getPrev(),"Null value expected!");
	}
	
	@Test
	void addingElements_test() //Testing the add at head method
	{
		gll.addLast(3);
		gll.addFirst(1);
		gll.addFirst(0);
		
		assertEquals(0,gll.get(0), "Wrong Head Value!"); //Testing the add at head method
		assertEquals(3,gll.get(3), "Wrong Tail Value!"); //Testing the add at tail method
		assertEquals(4,gll.size(), "Wrong Size Value!"); //Testing the get size head method
	}
	
	@Test
	void forEach_test() //Testing if the for each loop works
	{
		gll.addLast(3);
		gll.addFirst(1);
		gll.addFirst(0);
		
		int count = 0;
		for(Integer t : gll)
		{
			count++;
		}
		assertEquals(4,count,"Wrong Value");
	}
	
	@Test
	void containsTrue_test() //Testing if the contains method returns true appropriately
	{
		assertEquals(true,gll.contains(1), "Wrong Value!");
	}
	
	@Test
	void containsFalse_test() //Testing if the contains method returns false appropriately
	{
		assertEquals(false, gll.contains(6), "Wrong Value!");
	}
	
	@Test
	void removeTrue_test() //Testing if the remove method returns true appropriately
	{
		assertEquals(true, gll.remove(3), "Wrong Value!");
	}
	
	@Test
	void removeFalse_test() //Testing if the remove method returns false appropriately
	{
		assertEquals(false, gll.remove(3), "Wrong Value!");
	}
	
	@Test
	void getValid_test() //Testing if the get method retrieves the correct value
	{
		assertEquals(2, gll.get(2), "Wrong Value!");
	}
	
	@Test
	void getNull_test() //Testing if the get method return null as expected
	{
		assertEquals(null, gll.get(3), "Wrong Value!");
	}
	
	@Test
	void setReturn_test() //Testing if the set method returns the correct value
	{
		assertEquals(0, gll.set(0,99), "Wrong Value!");
	}
	
	@Test
	void removeHead_test() //Testing if the head of the list is removed by the method
	{
		assertEquals(99, gll.removeHead(), "Wrong Value!");
	}
	
	@Test
	void removeHead_test2() //Testing if the head of the list is updated
	{
		assertEquals(2, gll.get(0), "Wrong Value!");
	}
	
	@Test
	void removeTail_test() //Testing if the tail of the list is removed by the method
	{
		assertEquals(3, gll.removeTail(), "Wrong Value!");
	}
	
	@Test
	void removeTail_test2() //Testing if the tail is updated
	{
		assertEquals(null, gll.get(2), "Wrong Value!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
