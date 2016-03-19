package memento;

import java.util.HashMap;

public class Memento {
	private HashMap<String, String> stateMap;
	public Memento(HashMap<String, String> stateMap){
		this.setStateMap(stateMap);
	}
	public HashMap<String, String> getStateMap() {
		return stateMap;
	}
	public void setStateMap(HashMap<String, String> stateMap) {
		this.stateMap = stateMap;
	}
}
