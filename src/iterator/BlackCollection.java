package iterator;

public class BlackCollection implements Collection {
	private Object[] objArray;
	public BlackCollection(Object[] objArray){
		this.objArray = objArray;
	}
	@Override
	public Iterator iterator() {
		return new MyIerator();
	}
	//inner class
	private class MyIerator implements Iterator{
		private int pos = -1;
		@Override
		public Object next() {
			if(hasNext())
				pos++;
			return objArray[pos];
		}
		@Override
		public boolean hasNext() {
			if(pos<objArray.length-1)
				return true;
			else
				return false;
		}
		@Override
		public Object first() {
			pos = 0;
			return objArray[pos];
		}
	}
}
