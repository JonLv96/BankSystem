package com.cn.bank.dao.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.bank.dao.BankDao;
import com.cn.bank.domain.Money;
import com.cn.bank.domain.User;
import com.cn.bank.utils.JDBCUtils;

public class BankDaoImpl implements BankDao {

	@Override
	public User login(User user) throws Exception {
		//找到驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.1:3306/Bank","root","123456");
		String sql = "select * from user where userCounter = ? and userPassword = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,user.getUserCounter());
		pst.setString(2,user.getUserPassword());
		ResultSet rs = pst.executeQuery();
		List<User> list = new ArrayList<User>();
		User user2 = new User();
		while(rs.next()) {
			user2.setUserName(rs.getString(1));
			user2.setIDCard(rs.getString(2));
			user2.setUserCounter(rs.getString(3));
			user2.setUserPassword(rs.getString(4));
			Money money = new Money(rs.getDouble(5));
			user2.setMoney(money);
			list.add(user2);
		}
		
		
		rs.close();
		pst.close();
		conn.close();
		return user2;
	}

	@Override
	public void register(User user) throws Exception {
		//找到驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.1:3306/Bank","root","123456");
		String sql = "insert into user values(?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,user.getUserName());
		pst.setString(2,user.getIDCard());
		pst.setString(3,user.getUserCounter());
		pst.setString(4,user.getUserPassword());
		pst.setInt(5,(int)user.getMoney().getMoney());
		pst.execute();

		
		pst.close();
		conn.close();
	}

	@Override
	public void deposit(User user) throws Exception {
		
		//找到驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.1:3306/Bank","root","123456");
		String sql = "update user set userName=?,IDCard=?,userPassword=?,money=? where userCounter=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,user.getUserName());
		pst.setString(2,user.getIDCard());
		pst.setString(3,user.getUserPassword());
		pst.setInt(4,(int)user.getMoney().getMoney());
		pst.setString(5,user.getUserCounter());
		pst.execute();

		
		pst.close();
		conn.close();
	}

	@Override
	public User findUserByCounter(User user) throws Exception {
		//找到驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.1:3306/Bank","root","123456");
		String sql = "select * from user where userCounter = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,user.getUserCounter());
		ResultSet rs = pst.executeQuery();
		User user2 = new User();
		while(rs.next()) {
			user2.setUserName(rs.getString(1));
			user2.setIDCard(rs.getString(2));
			user2.setUserCounter(rs.getString(3));
			user2.setUserPassword(rs.getString(4));
			Money money = new Money(rs.getDouble(5));
			user2.setMoney(money);
		}

		
		rs.close();
		pst.close();
		conn.close();
		return user2;
	}

	@Override
	public void modify(User user) throws Exception {
		//找到驱动
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(user.toString());
		//获取连接
		Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.1:3306/Bank","root","123456");
		String sql = "update user set userName=?,IDCard=?,userPassword=?,money=? where userCounter=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,user.getUserName());
		pst.setString(2,user.getIDCard());
		pst.setString(3,user.getUserPassword());
		pst.setInt(4,(int)user.getMoney().getMoney());
		pst.setString(5,user.getUserCounter());
		pst.execute();
		
		pst.close();
		conn.close();
	}

	@Override
	public void tansfer(Connection conn, User user_current, User user_target, double money)throws Exception {
		String sql1 = "update user set money=? where userCounter=?";
		PreparedStatement pst = conn.prepareStatement(sql1);
		pst.setInt(1,(int)(user_current.getMoney().getMoney()-money));
		pst.setString(2,user_current.getUserCounter());
		pst.execute();
		
		String sql2 = "update user set money=? where userCounter=?";
		PreparedStatement pst2 = conn.prepareStatement(sql2);
		pst2.setInt(1,(int)(user_target.getMoney().getMoney()+money));
		pst2.setString(2,user_target.getUserCounter());
		pst2.execute();
		
		pst.close();
		pst2.close();
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
//		BankDaoImpl b = new BankDaoImpl();
//		User user1 = new User("kkgs199","123456789","321","321",new Money(10000));
//		User user2= new User("lvqiang","360722","123456","123456",new Money(100200));
////		b.register(new User("kkgs","110","2016","2016",new Money(1000)));
////		b.login(new User("kkgs","2016"));
//		Class.forName("com.mysql.jdbc.Driver");
//		//获取连接
//		Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.1:3306/Bank","root","123456");
//		
//		b.tansfer(conn, user1, user2, 100);
	}
}
