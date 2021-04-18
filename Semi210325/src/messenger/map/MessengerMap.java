package messenger.map;

import java.util.HashMap;
import java.util.Map;

public class MessengerMap {

	private static MessengerMap	msgrMap	= null;
	private Map<String, Object>	map		= null;

	private MessengerMap() {
		columnInit();
	}

	public static MessengerMap getInstance() {

		if (msgrMap == null) {
			msgrMap = new MessengerMap();
		}
		return msgrMap;
	}

	private void columnInit() {
		map = new HashMap<String, Object>();
		/* 모든 테이블의 컬럼 미리 put 해놓기 */
		map.put("id", "");
		map.put("password", "");
		map.put("nickname", "");
		/* 모든 테이블의 컬럼 미리 put 해놓기 */
	}

	public Map<String, Object> getMap() {
		return map;
	}

//	public void setMap(Map<String, Object> map) {
//		this.map = map;
//	}
}
