package com.cn.bank.dao;

import java.sql.Connection;
import java.util.List;

import com.cn.bank.domain.User;

public interface BankDao {

	void register(User user) throws Exception;

	User login(User user) throws Exception;

	void deposit(User user)throws Exception;

	User findUserByCounter(User user)throws Exception;

	void modify(User user)throws Exception;

	void tansfer(Connection conn, User user_current, User user_target, double money)throws Exception;


}
