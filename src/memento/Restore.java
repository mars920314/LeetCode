package memento;

import java.util.HashMap;

public abstract class Restore<T> {
	public abstract void MakeRestore(T obj, HashMap<String, String> stateMap);
}
