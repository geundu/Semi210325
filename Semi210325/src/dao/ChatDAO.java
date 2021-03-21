package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.ChatVO;

public class ChatDAO {
	SqlSessionFactory factory;

	private SqlSessionFactory getSqlSessionFactory() {
		if (factory != null) {
			return factory;
		}

		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // 설정파일을 읽기 위한 객체
		factory = builder.build(is);
		return factory;
	}

	public ChatVO getNicknameById(String id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ChatVO member = (ChatVO) sqlSession.selectOne("dao.mapper.MemberMapper.getNicknameById", id);

		sqlSession.close();

		return member;

	}

	public static void main(String[] args) {
		ChatDAO dao = new ChatDAO();
		ChatVO member = null;
		ArrayList<ChatVO> voList = new ArrayList<ChatVO>();
		for (int i = 1; i < 8; i++) {
			member = dao.getNicknameById("testuser" + i);
			voList.add(member);
		}
		for (ChatVO index : voList) {
			System.out.println(index.getPassword());
		}
	}
}
