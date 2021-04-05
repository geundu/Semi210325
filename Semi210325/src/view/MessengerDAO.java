package view;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.MessengerVO;

public class MessengerDAO {
	SqlSessionFactory factory = null;

	public MessengerVO login(MessengerVO msgrVO) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession sqlSession = factory.openSession();
		msgrVO = sqlSession.selectOne("model.MessengerMapper.login", msgrVO);

		sqlSession.close();

		return msgrVO;
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

//	public static void main(String[] args) {
//		MessengerDAO	msgrDAO	= new MessengerDAO();
//		MessengerVO		msgrVO	= new MessengerVO("testuser1", "123");
//		System.out.println(msgrVO);
//		msgrVO = msgrDAO.login(msgrVO);
//
//		System.out.println(msgrVO.getId() + msgrVO.getPassword() + msgrVO.getNickname());
//	}
}
