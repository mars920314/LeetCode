package iterator;

public class MyIterator implements Iterator {
	private WriteCollection collection;
	private int pos = -1;
	public MyIterator(WriteCollection collection){
		this.collection = collection;
	}
	@Override
	public Object next() {
		if(hasNext())
			pos++;
		return collection.get(pos);
	}
	@Override
	public boolean hasNext() {
		if(pos<collection.size()-1)
			return true;
		else
			return false;
	}
	@Override
	public Object first() {
		pos = 0;
		return collection.get(pos);
	}
}
