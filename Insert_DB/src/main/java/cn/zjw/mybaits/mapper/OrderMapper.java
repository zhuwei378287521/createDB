package cn.zjw.mybaits.mapper;

import java.util.List;

import cn.zjw.mybaits.mapper.po.Orders;
import cn.zjw.mybaits.mapper.po.User;

public interface OrderMapper {
	//根据用户id查询用户信息
	public User findOrderById(int id) throws Exception;
	//添加用户信息
	public void insertOrder(Orders order)throws Exception; 
}
