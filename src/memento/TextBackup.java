package memento;

import java.util.HashMap;

public class TextBackup extends Backup<Text> {
	@Override
	public HashMap<String, String> MakeBackup(Text obj){
		HashMap<String, String> stateMap = new HashMap<String, String>();
		stateMap.put("paragraph1", obj.paragraph1);
		stateMap.put("paragraph2", obj.paragraph2);
		stateMap.put("paragraph3", obj.paragraph3);
		return stateMap;
	}
}
