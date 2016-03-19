package iterator;

public class WriteCollection implements Collection {
	private Object[] objArray;
	public WriteCollection(Object[] objArray){
		this.objArray = objArray;
	}
	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}
	public Object get(int pos){
		if(pos<objArray.length)
			return objArray[pos];
		else
			return null;
	}
	public int size(){
		return objArray.length;
	}
}
