package memento;

import java.util.HashMap;

public class TextRestore extends Restore<Text> {
	@Override
	public void MakeRestore(Text obj, HashMap<String, String> stateMap) {
		obj.paragraph1 = stateMap.get("paragraph1");
		obj.paragraph2 = stateMap.get("paragraph2");
		obj.paragraph3 = stateMap.get("paragraph3");
	}
}
