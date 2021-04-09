package vo;

import java.util.HashMap;
import java.util.Map;

public class MessengerMap {

	private Map<String, Object> voMap = null;

	public MessengerMap() {
		voMap = new HashMap<String, Object>();
		voMap.put("id", "");
		voMap.put("password", "");
	}

	public Map<String, Object> getVoMap() {
		return voMap;
	}

	public void setVoMap(Map<String, Object> voMap) {
		this.voMap = voMap;
	}
}
