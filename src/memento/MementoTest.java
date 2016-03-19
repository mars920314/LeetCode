package memento;

public class MementoTest {
	public static void main(String[] args){
		Storage  store = new Storage();
		Text text = new Text();
		text.paragraph1 = "p1-state001";
		text.paragraph2 = "p2-state001";
		text.paragraph3 = "p3-state001";
		store.setMemento("state001", text.createMemento());
		System.out.println("===��ʼ��״̬===\n"+text);
		text.paragraph1 = "p1-state002";
		text.paragraph2 = "p2-state002";
		text.paragraph3 = "p3-state002";
		System.out.println("===�޸ĺ�״̬===\n"+text);
		text.restoreMemento(store.getMemento("state001"));
		System.out.println("===�ָ���״̬===\n"+text);
	}
}
