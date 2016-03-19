package memento;

public class Text {
	public String paragraph1;
	public String paragraph2;
	public String paragraph3;
	public Memento createMemento(){
		Backup<Text> backup = new TextBackup();
		return new Memento(backup.MakeBackup(this));
	}
	public void restoreMemento(Memento memento){
		Restore<Text> restore = new TextRestore();
		restore.MakeRestore(this, memento.getStateMap());
	}
	public String toString(){
		return "paragraph1 = "+paragraph1+"; paragraph2 = "+paragraph2+"; paragraph3 = "+paragraph3;
	}
}
