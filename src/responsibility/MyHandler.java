package responsibility;

public class MyHandler extends AbstractHandler implements Handler {
	private String name;
	public MyHandler(String name){
		this.name = name;
	}
	@Override
	public void operate() {
		if(getHandler()!=null){
			getHandler().operate();
		}
		System.out.println(name + " is deal");
	}
}
