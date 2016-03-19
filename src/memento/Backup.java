package memento;

import java.util.HashMap;

public abstract class Backup<T> {
	public abstract HashMap<String, String> MakeBackup(T obj);
}
