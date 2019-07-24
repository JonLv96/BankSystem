package com.cn.bank.service.serviceImpl;


import java.sql.Connection;
import java.sql.DriverManager;

import com.cn.bank.dao.BankDao;
import com.cn.bank.dao.daoImpl.BankDaoImpl;
import com.cn.bank.domain.Money;
import com.cn.bank.domain.User;
import com.cn.bank.service.BankService;

public class BankServiceImpl implements BankService{

	BankDao bankDao = new BankDaoImpl(); 

	@Override
	public void deposit(User user) throws Exception {
		bankDao.deposit(user);
	}
	@Override
	public User login(User user) throws Exception {
		return bankDao.login(user);
	}

	@Override
	public void register(User user) throws Exception {
		bankDao.register(user);
	}
	@Override
	public User findUserByCounter(User user) throws Exception {
		return bankDao.findUserByCounter(user);
	}
	@Override
	public void modify(User user) throws Exception {
		bankDao.modify(user);
	}
	@Override
	public void tansfer(User user_current, User user_target, double money) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.1:3306/Bank","root","123456");
		
		User user11 = bankDao.findUserByCounter(user_target);
		
		try {
			conn.setAutoCommit(false);
			bankDao.tansfer(conn,user_current,user11,money);
			conn.commit();
			System.out.println("提交");
		} catch (Exception e) {
			System.out.println("异常回滚");
			conn.rollback();
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
	}
	
//	public static void main(String[] args) throws Exception {
//		User user1 = new User("kkgs199","123456789","321","321",new Money(10000));
//		User user2= new User("lvqiang","360722","123456","123456",new Money(100200));
//
//		BankServiceImpl bs = new BankServiceImpl();
//		bs.tansfer(user1, user2, 100);
//	}
}
