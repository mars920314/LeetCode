package iterator;

public class IteratorTest {
	public static void main(String[] args){
		Object[] objArray = {"One","Two","Three","Four","Five","Six"};
		Collection collection = new WriteCollection(objArray);
		Iterator iterator = collection.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}
}
