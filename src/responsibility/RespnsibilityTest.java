package responsibility;

public class RespnsibilityTest {
	public static void main(String[] args){
		MyHandler applicant = new MyHandler("applicant");
		MyHandler manager = new MyHandler("manager");
		MyHandler ceo = new MyHandler("ceo");
		applicant.setHandler(manager);
		manager.setHandler(ceo);
		applicant.operate();
	}
}
