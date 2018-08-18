package cn.zjw.mybaits.mapper.test;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.zjw.mybaits.mapper.OrderMapper;
import cn.zjw.mybaits.mapper.UserMapper;
import cn.zjw.mybaits.mapper.po.Orders;
import cn.zjw.mybaits.mapper.po.User;
import junit.framework.TestCase;
import zjw.generater.data.CreatDate;
import zjw.generater.name.Name;

public class OrderMapperTest extends TestCase {
	public SqlSessionFactory sqlSessionFactory;

	protected void setUp() throws Exception {
		// mybatis配置文件
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 使用SqlSessionFactoryBuilder创建sessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

//	@Test
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
	public void testInsertOrder()  {
		int i = 0;
		// 获取session
		SqlSession session = sqlSessionFactory.openSession();
		// 获取mapper接口的代理对象
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);

		while (true) {
			i++;
			// 要添加的数据
			Orders order = new Orders();
			order.setUserId(new Random().nextInt(100000));
			order.setNumber(String.valueOf(new Random().nextInt(100000)));
			order.setCreatetime(CreatDate.getCDate());
			
			try {
				orderMapper.insertOrder(order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
