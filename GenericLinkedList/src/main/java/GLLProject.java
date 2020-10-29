/*
  Author: Ronak Trivedi
   netID: rtrive6

    Date: September 2020
*///---------------------------------------------------

/*
 * This class will eventually contain the user interface
 */
public class GLLProject {

	public static void main(String[] args) {
		GenericLinkedList<Integer> gll;
		gll = new GenericLinkedList<>(99);
		gll.addLast(3);
		gll.addFirst(1);
		gll.addFirst(0);
		
		// TODO Auto-generated method stub
		for(Integer t : gll)
		{
			System.out.println(t);
		}
		
	}
}
