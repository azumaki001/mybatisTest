package test.main;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.entity.TestEntity;
import test.mapper.TestEntityMapper;

public class PostGresTest {

	public static void main(String[] args) throws IOException {
		//①InputStream in = PostGresTest.class.getResourceAsStream("../../resources/mybatis-config.xml");
		//①SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//①SqlSession session = sqlSessionFactory.openSession();
		String resource = "resources/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

		//selectTest(sqlMapper);

		insertTest(sqlMapper);

	}

	private static void selectTest(SqlSessionFactory sqlMapper) {
		// TODO 自動生成されたメソッド・スタブ
		SqlSession session = sqlMapper.openSession();
		try {
			//①TestEntity te = (TestEntity) session.selectOne("test.entity.TestEntity.selectById", 1001);
			TestEntityMapper tem = session.getMapper(TestEntityMapper.class);
			TestEntity te = tem.selectById(1001);
			System.out.println(te.getId());
			System.out.println(te.getNick_name());
			System.out.println(te.getFull_name());
		} finally {
		session.close();
		}
	}

	private static void insertTest(SqlSessionFactory sqlMapper) {
		// TODO 自動生成されたメソッド・スタブ
		SqlSession session = sqlMapper.openSession();
		try {
			TestEntityMapper tem = session.getMapper(TestEntityMapper.class);
			TestEntity te = new TestEntity();
			te.setId(1002);
			te.setNick_name("insert test nick name");
			te.setFull_name("insert test full name");

			tem.insertAll(te);
		} finally {
		session.commit();
		session.close();
		}
	}

}
