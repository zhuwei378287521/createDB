package cn.zjw.mybaits.mapper.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.zjw.mybaits.mapper.UserMapper;
import cn.zjw.mybaits.mapper.po.User;
import junit.framework.TestCase;
import zjw.generater.data.CreatDate;
import zjw.generater.name.Name;

public class UserMapperTest extends TestCase {
	public SqlSessionFactory sqlSessionFactory;

	protected void setUp() throws Exception {
		// mybatis配置文件
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 使用SqlSessionFactoryBuilder创建sessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 调用代理对象方法
		User user = userMapper.findUserById(1);
		System.out.println("找到用户名" + user);
		// 关闭session
		session.close();

	}

	@Test
	public void testFindUserByUsername() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByUsername("zjw");
		System.out.println(list.size());
	}

	@Test
	public void testInsertUser() throws Exception {
		int i = 0;
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);

		while (true) {
			i++;
			// 要添加的数据
			User user = new User();
			user.setUsername(Name.getName());
			user.setBirthday(CreatDate.getCDate());
			user.setSex(String.valueOf((new Random().nextInt(2))));
			user.setAddress("北京市");
			// 通过mapper接口添加用户
			userMapper.insertUser(user);

			if (i == 900) {
				i = 0;
				// 提交
				session.commit();
			}

		}
		// 关闭session
//		session.close();
//		System.out.println("插入成功");

	}
}
