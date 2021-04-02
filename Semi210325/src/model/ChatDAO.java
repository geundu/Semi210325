package model;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.ChatVO;

public class ChatDAO {
	SqlSessionFactory factory;

	public ChatVO getNicknameById(String id) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession	sqlSession	= factory.openSession();
		ChatVO		member		= sqlSession.selectOne("model.MemberMapper.getNicknameById", id);

		sqlSession.close();

		return member;

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
		ChatDAO					dao		= new ChatDAO();
//		ChatVO				member	= null;
//		ArrayList<ChatVO>	voList	= new ArrayList<ChatVO>();

//		for (int i = 1; i < 8; i++) {
//			member = dao.getNicknameById("testuser" + i);
//			voList.add(member);
//		}
//
//		for (ChatVO index : voList) {
//			System.out.println(index.getNickname());
//		}
		Map<String, Object>	mapTest	= new HashMap<String, Object>();
		mapTest = (HashMap<String, Object>) dao.loginProcedure("testuser1", "123", mapTest);
		System.out.println(mapTest);

		Object[] hello = mapTest.keySet().toArray();

		for (Object o : hello) {
			System.out.println(o);
		}
	}
}
