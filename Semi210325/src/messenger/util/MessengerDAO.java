package messenger.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import messenger.map.MessengerMap;

public class MessengerDAO {

	private static MessengerDAO dao = null;

	private MessengerDAO() {

	}

	public static MessengerDAO getInstance() {

		if (dao == null) {
			dao = new MessengerDAO();
		}
		return dao;
	}

	SqlSessionFactory factory = null;

	public List<Map<String, Object>> signIn(Map<String, Object> pMap) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession					sqlSession	= factory.openSession();
		List<Map<String, Object>>	tempList	= sqlSession.selectList("messenger.util.MessengerMapper.signIn", pMap);

		sqlSession.close();

		return tempList;
	}

	public List<Map<String, Object>> getBuddyList(Map<String, Object> pMap) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession					sqlSession	= factory.openSession();
		List<Map<String, Object>>	tempList	= sqlSession.selectList("messenger.util.MessengerMapper.getBuddyList", pMap);

		sqlSession.close();

		return tempList;
	}

	public int signUp(Map<String, Object> pMap) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession	sqlSession	= factory.openSession();
		int			accept		= sqlSession.insert("messenger.util.MessengerMapper.signUp", pMap);
		sqlSession.commit();

		sqlSession.close();
		return accept;
	}

	public List<Map<String, Object>> idCheck(Map<String, Object> pMap) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession					sqlSession	= factory.openSession();
		List<Map<String, Object>>	tempList	= sqlSession.selectList("messenger.util.MessengerMapper.idCheck", pMap);

		sqlSession.close();
		return tempList;
	}

	public Map<String, Object> loginProcedure(String id, String password, Map<String, Object> map) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession sqlSession = factory.openSession();

		map.put("id", id);
		map.put("password", password);
		sqlSession.selectOne("model.MemberMapper.mapProcedureTest", map);

		sqlSession.close();

		return map;
	}

	public static void main(String[] args) {
		MessengerDAO				dao		= new MessengerDAO();
		MessengerMap				pMap	= MessengerMap.getInstance();
		List<Map<String, Object>>	list	= new ArrayList<Map<String, Object>>();

		pMap.getMap().put("mem_id_vc", "test1");

		list = dao.getBuddyList(pMap.getMap());

		for (Map<String, Object> index : list) {
			System.out.println(index);
		}
	}
}
